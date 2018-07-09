package service;

import DAO.ReplyDAO;
import entity.Reply_detail;
import util.PageUtil;

public class ReplyService {
	private ReplyDAO replyDAO = new ReplyDAO();
	public PageUtil showDetail(String invitId,int index,int page) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.setIndex(index);
		pageUtil.setPage(page);
		pageUtil.setList(replyDAO.showDetail(invitId,index,page));
		pageUtil.setTotalRecouds(replyDAO.getCount(invitId));
		pageUtil.setTotalPage((pageUtil.getTotalRecouds()-1)/(pageUtil.getPage())+1);
		return pageUtil;
	}
	public int writeDetail(Reply_detail reply_detail) {
		return replyDAO.writeDetail(reply_detail);
	}
}
