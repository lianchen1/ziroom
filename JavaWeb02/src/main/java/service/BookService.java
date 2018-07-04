package service;

import java.util.List;
import java.util.Map;

import util.PageUtil;

import entity.BookInfo;
import entity.BookType;

import DAO.BookInfoDAO;
import DAO.BookTypeDAO;

public class BookService {
	private BookInfoDAO bookInfoDAO = new BookInfoDAO();
	private BookTypeDAO bookTypeDAO = new BookTypeDAO();
	//获得所有图书分类
	public List<BookType> getBooksTypes(){
		return bookTypeDAO.getBookType();
	}
	//条件查找图书
	public PageUtil findBooks(BookInfo bookInfo,int index,int page){
		return bookInfoDAO.findBooks(bookInfo,index,page);
	}
}
