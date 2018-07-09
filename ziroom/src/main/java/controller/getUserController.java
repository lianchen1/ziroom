package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

public class getUserController {
	public void getUser(HttpServletRequest request, HttpServletResponse response) {
		Object obj = request.getSession().getAttribute("user");
		if(obj != null) {
			User user = (User)obj;
			
		}
	}
}
