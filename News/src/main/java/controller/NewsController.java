package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.News_comment;
import service.CommentService;
import service.NewsService;
import util.PageUtil;

public class NewsController {
	public void getNews(HttpServletRequest request,HttpServletResponse response) {
		NewsService newsService = new NewsService();
		String newName = request.getParameter("newName");
		String indexStr = request.getParameter("index");
		if(indexStr == null) {
			indexStr = "0";
		}
		int index = Integer.valueOf(indexStr);
		PageUtil pageUtil = newsService.showNews(newName,index,5);
		try {
			response.getWriter().write(JSON.toJSONString(pageUtil));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getCom(HttpServletRequest request,HttpServletResponse response) {
		NewsService newsService = new NewsService();
		String comId = request.getParameter("comId");
		System.out.println(comId);
		String indexStr = request.getParameter("index");
		if(indexStr == null) {
			indexStr = "0";
		}
		int index = Integer.valueOf(indexStr);
		PageUtil pageUtil = newsService.showComments(comId, index, 5);
		try {
			response.getWriter().write(JSON.toJSONString(pageUtil));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void delNew(HttpServletRequest request,HttpServletResponse response) {
		NewsService newsService = new NewsService();
		String newId = request.getParameter("newId");
		newsService.delNew(newId);
		try {
			response.sendRedirect("index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeCom(HttpServletRequest request,HttpServletResponse response) {
		News_comment com = new News_comment();
		CommentService commentService = new CommentService();
		String newIdStr = request.getParameter("newId");
		if(newIdStr != null) {
			request.getSession().setAttribute("newId", newIdStr);
		}
		int newId = Integer.valueOf(request.getSession().getAttribute("newId").toString());
		String comText = request.getParameter("comText");
		String comName = request.getParameter("comName");
		if(newIdStr == null) {
			com.setNewsid(newId);
			com.setContent(comText);
			com.setAuthor(comName);
			commentService.writeCom(com);
		}
		try {
			if(newIdStr != null) {
				request.getRequestDispatcher("writeCom.html").forward(request, response);
			}else {
				response.sendRedirect("index.html");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
