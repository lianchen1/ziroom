package controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String url = request.getRequestURI();
		//从url获取调用的类
		String clazzName = url.substring(0, url.lastIndexOf("/"));
		String clazzType = clazzName.substring(clazzName.lastIndexOf("/")+1)+"Controller";
		//从url获取方法名
		String methodName = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf(".do"));
		//获得到类名和里面的方法名，利用反射调用这个方法
		try {
			Class clazz = Class.forName("controller."+clazzType);
			Object obj = clazz.newInstance();
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(obj, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
