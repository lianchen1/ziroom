package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.PageUtil;

import entity.BookInfo;

public class BookInfoDAO extends BaseDAO<BookInfo>{
	//条件查找图书
	public PageUtil findBooks(BookInfo bookInfo,int index,int page){
		String sql = "select * from book_info bi inner join book_type bt where bi.book_type = bt.id";
		List<Object> lists = new ArrayList<Object>();
		if(bookInfo.getBook_type() != null){
			sql += " and book_type = ?";
			lists.add(bookInfo.getBook_type());
		}
		if(bookInfo.getBook_name() != null){
			sql += " and book_name like concat ('%',?,'%')";
			lists.add(bookInfo.getBook_name());
		}
		if(bookInfo.getIs_borrow() != null){
			sql += " and is_borrow = ?";
			lists.add(bookInfo.getIs_borrow());
		}
		PageUtil pageUtil = new PageUtil();
		sql +=" limit "+(index-1)*page+","+page;
		pageUtil.index = index;
		pageUtil.page = page;
		pageUtil.totalRecouds = this.getTotalRecounds(bookInfo, index, page);
		pageUtil.totalPage = (pageUtil.totalRecouds-1)/pageUtil.page+1;
		pageUtil.books = super.selectDatas(sql, lists);
		return pageUtil;
	}
	public int getTotalRecounds(BookInfo bookInfo,int index,int page){
		String sql = "select count(1) count from book_info bi inner join book_type bt where bi.book_type = bt.id";
		List<Object> lists = new ArrayList<Object>();
		if(bookInfo.getBook_type() != null){
			sql += " and book_type = ?";
			lists.add(bookInfo.getBook_type());
		}
		if(bookInfo.getBook_name() != null){
			sql += " and book_name like concat ('%',?,'%')";
			lists.add(bookInfo.getBook_name());
		}
		if(bookInfo.getIs_borrow() != null){
			sql += " and is_borrow = ?";
			lists.add(bookInfo.getIs_borrow());
		}
		return Integer.valueOf(super.selectDatas(sql, lists).get(0).get("count").toString());
	}
}
