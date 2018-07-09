package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import service.InvitationService;
import util.PageUtil;

public class InvitController {
	public void showInvit(HttpServletRequest request,HttpServletResponse response) {
		String invitName = request.getParameter("invitName");
		String indexStr = request.getParameter("index");
		Integer index = 0;
		if(indexStr != null) {
			index = Integer.valueOf(indexStr);
		}
		InvitationService invitationService = new InvitationService();
		PageUtil pageUtil = invitationService.showInvit(invitName,index,2);
		try {
			response.getWriter().write(JSON.toJSONString(pageUtil));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delInvit(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String invitId = request.getParameter("invitId");
		int invid = Integer.valueOf(invitId);
		InvitationService invitationService = new InvitationService();
		boolean b = invitationService.delInvit(invid);
		System.out.println(b);
		response.sendRedirect("/JavaWeb02/index.html");
	}
}
