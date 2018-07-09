package service;


import DAO.InvitationDAO;
import DAO.ReplyDAO;
import util.PageUtil;

public class InvitationService {
	private InvitationDAO invitationDAO = new InvitationDAO();
	public PageUtil showInvit(String invitName,int index, int page){
		PageUtil pageUtil = new PageUtil();
		pageUtil.setList(invitationDAO.showInvit(invitName,index,page));
		pageUtil.setIndex(index);
		pageUtil.setPage(page);
		pageUtil.setTotalRecouds(invitationDAO.getCount(invitName));
		pageUtil.setTotalPage((pageUtil.getTotalRecouds()-1)/(pageUtil.getPage())+1);
		return pageUtil;
	}
	public boolean delInvit(int invitId) {
		ReplyDAO replyDAO = new ReplyDAO();
		if(invitationDAO.delInvit(invitId)!=-1&&(replyDAO.delDetail(invitId))!=-1) {
			return true;
		}else {
			return false;
		}
	}
}
