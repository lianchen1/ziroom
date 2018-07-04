package controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Users;

import service.UserService;

public class UserController {
	public void register(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Users user = new Users();
		String user_code = request.getParameter("user_code");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String sex = null;
		if(!request.getParameter("sex").equals("-1")){
			sex = request.getParameter("sex");
		}
		user.setUser_code(user_code);
		user.setPassword(password);
		user.setEmail(email);
		user.setGender(sex);
		UserService userService = new UserService();
		int result = userService.register(user);
		if(result == -1){
			request.setAttribute("registerError", "用户名已存在");
			request.getRequestDispatcher("/JavaWeb02/register.jsp").forward(request, response);
		}else{
			response.sendRedirect("/JavaWeb02/login.jsp");
		}
	}
	public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String user_code = request.getParameter("user_code");
		String password = request.getParameter("password");
		UserService userService = new UserService();
		Map<String, Object> map = userService.login(user_code, password);
		Set set = new HashSet();
		set = map.keySet();
		for (Object obj : set) {
			if(obj.equals("login_error")){
				request.setAttribute("login_error", map.get(obj));
			}else{
				request.getSession().setAttribute("user", map.get(obj));
			}
		}
	}
}
