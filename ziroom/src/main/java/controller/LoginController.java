package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.User;
import service.UserService;

public class LoginController {
	private UserService userService = new UserService();
	public void login(HttpServletRequest request, HttpServletResponse response) {
		String userCode = request.getParameter("userCode");
		String password = request.getParameter("password");
		try {
			User user = userService.login(userCode, password);
			request.getSession().setAttribute("user", user);
			response.getWriter().write(JSON.toJSONString(user));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().write(JSON.toJSONString(e));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
