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
		//��url��ȡ���õ���
		String clazzName = url.substring(0, url.lastIndexOf("/"));
		String clazzType = clazzName.substring(clazzName.lastIndexOf("/")+1)+"Controller";
		//��url��ȡ������
		String methodName = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf(".do"));
		//��õ�����������ķ����������÷�������������
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
