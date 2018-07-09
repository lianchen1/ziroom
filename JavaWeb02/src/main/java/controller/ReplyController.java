package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.Reply_detail;
import service.ReplyService;
import util.PageUtil;

public class ReplyController {
	ReplyService replyService = new ReplyService();
	public void showDetail(HttpServletRequest request,HttpServletResponse response) {
		String invitId = request.getParameter("invitId");
		String indexStr = request.getParameter("index");
		Integer index = 0;
		if(indexStr != null) {
			index = Integer.valueOf(indexStr);
		}
		PageUtil pageUtil = replyService.showDetail(invitId, index, 2);
		System.out.println(pageUtil.list);
		try {
			response.getWriter().write(JSON.toJSONString(pageUtil));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeDetail(HttpServletRequest request,HttpServletResponse response) {
		System.out.println(1);
		String invitStr = request.getParameter("invitId");
		if(invitStr!=null) {
			request.getSession().setAttribute("invitId", invitStr);
			try {
				request.getRequestDispatcher("/write.html").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			String comText = request.getParameter("comText");
			String comName = request.getParameter("comName");
			Object invitIdStr = request.getSession().getAttribute("invitId");
			int invitId = Integer.valueOf(invitIdStr.toString());
			Reply_detail reply_detail = new Reply_detail();
			reply_detail.setContent(comText);
			reply_detail.setInvid(invitId);
			reply_detail.setAuthor(comName);
			System.out.println(reply_detail.toString());
			if(replyService.writeDetail(reply_detail)!=-1) {
				try {
					response.sendRedirect("/JavaWeb02/Detail.html?invitId="+invitId);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
