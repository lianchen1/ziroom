package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.User;
import service.UserService;
import util.SendMsgDemo1.MobileMessageSend;
import util.SendMsgDemo2.MobileMessageCheck;

public class RegisterController {
	private UserService userService = new UserService();
	//��֤�ֻ��Ŵ治����
	public void findPhone(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String user_number = request.getParameter("phone");
		if(userService.findPhone(user_number)) {
			response.getWriter().write(JSON.toJSONString("�ֻ����ѱ�ע��"));
		} else {
			response.getWriter().write(JSON.toJSONString(""));
		}
	}
	/**
	 * �����ֻ���֤��
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doPhone(HttpServletRequest request, HttpServletResponse response) {
		String phoneNum = request.getParameter("phoneNum");
		try {
			String errorCode = MobileMessageSend.sendMsg(phoneNum);
			if("success".equals(errorCode)){
				response.getWriter().write(JSON.toJSONString(""));
			}else{
				response.getWriter().write(JSON.toJSONString("����ʧ��"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��֤�ֻ���֤��
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void isPhone(HttpServletRequest request, HttpServletResponse response) {
		String isPhone = request.getParameter("isPhone");
		String phoneNum = request.getParameter("phoneNum");
		try {
			String str = MobileMessageCheck.checkMsg(phoneNum, isPhone);
			if("success".equals(str)){
				System.out.println("�ֻ�������֤�ɹ���");
				response.getWriter().write(JSON.toJSONString(""));
			}else{
				System.out.println("�ֻ�������֤ʧ�ܣ�");
				response.getWriter().write(JSON.toJSONString("��֤�����"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//ע��
	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String user_number = request.getParameter("phone");
		String password = request.getParameter("password");
		if(user_number != null && password != null) {
			User user = new User();
			user.setUser_number(user_number);
			user.setUser_password(password);
			if(userService.register(user) == -1) {
				System.out.println("ע��ʧ��");
			}else {
				request.getSession().setAttribute("user", user);
				response.getWriter().write(JSON.toJSONString("ע��ɹ�"));
			}
		}
	}
}
