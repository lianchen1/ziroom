package service;

import DAO.CommentDAO;
import DAO.NewsDAO;
import util.PageUtil;

public class NewsService {
	NewsDAO newsDAO = new NewsDAO();
	CommentDAO commentDAO = new CommentDAO();
	//调用DAO层方法
	public PageUtil showNews(String newName,Integer index,Integer pageNum){
		PageUtil pageUtil = new PageUtil();
		pageUtil.index = index;
		pageUtil.pageNum = pageNum;
		pageUtil.totalPage = newsDAO.getPage(newName);
		pageUtil.totalNum = (pageUtil.totalPage-1)/pageNum+1;
		pageUtil.pageList = newsDAO.showNews(newName, index, pageNum);
		return pageUtil;
	}
	public PageUtil showComments(String comId,Integer index,Integer pageNum) {
		PageUtil pageUtil = new PageUtil();
		pageUtil.index = index;
		pageUtil.pageNum = pageNum;
		pageUtil.totalPage = commentDAO.getPage(comId);
		pageUtil.totalNum = (pageUtil.totalPage-1)/pageNum+1;
		pageUtil.pageList = commentDAO.getCom(comId, index, pageNum);
		return pageUtil;
	}
	public int delNew(String newId) {
		return newsDAO.delNew(newId);
	}
}
