package service;

import DAO.CommentDAO;
import entity.News_comment;

public class CommentService {
	CommentDAO commentDAO = new CommentDAO();
	public int writeCom(News_comment com) {
		return commentDAO.writeCom(com);
	}
}
