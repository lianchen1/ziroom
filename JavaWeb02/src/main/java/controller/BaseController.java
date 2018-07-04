package controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String url = request.getRequestURI();
		String clazzNameLast = url.substring(0,url.lastIndexOf("/"));
		String clazzName = clazzNameLast.substring(clazzNameLast.lastIndexOf("/")+1);
		String action = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("."));
		System.out.println(action);
		try {
			Class clazz = Class.forName("controller."+clazzName.substring(0,1).toUpperCase()+clazzName.substring(1)+"Controller");
			Object obj = clazz.newInstance();
			Method method = clazz.getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(obj, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

