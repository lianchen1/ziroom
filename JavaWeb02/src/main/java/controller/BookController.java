package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.BookInfo;
import entity.BookType;

import service.BookService;
import util.PageUtil;

public class BookController{
	public void  getBooks(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		BookService bookService = new BookService();
		List<BookType> bookTypes = bookService.getBooksTypes();
		String type = request.getParameter("type");
		String book_name = request.getParameter("bookname");
		String isBorrow = request.getParameter("isBorrow");
		BookInfo bookInfo = new BookInfo();
		if(type != null && !type.equals("-1")){
			bookInfo.setBook_type(Integer.valueOf(type));
		}
		bookInfo.setBook_name(book_name);
		if(isBorrow != null && !isBorrow.equals("-1")){
			bookInfo.setIs_borrow(Integer.valueOf(isBorrow));
		}
		String index = request.getParameter("index");
		if(index == null){
			index = "1";
		}
		Integer indexNum = Integer.valueOf(index);
		PageUtil pageUtil = bookService.findBooks(bookInfo,indexNum,2);
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("bookTypes", bookTypes);
		map.put("pageUtil", pageUtil);
		String json = JSON.toJSONString(map);
		System.out.println(json);
		response.getWriter().write(json);
	}
}
