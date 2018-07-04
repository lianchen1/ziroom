package DAO;

import java.util.ArrayList;
import java.util.List;

import entity.BookType;

public class BookTypeDAO extends BaseDAO<BookType>{
	//查询所有书分类
	public List<BookType> getBookType(){
		String sql = "select * from book_type";
		return super.selectData(sql, new ArrayList<Object>(){}, BookType.class);
	}
	public static void main(String[] args) {
		BookTypeDAO bt = new BookTypeDAO();
	}
}
