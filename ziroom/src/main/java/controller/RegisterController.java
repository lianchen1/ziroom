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
	//验证手机号存不存在
	public void findPhone(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String user_number = request.getParameter("phone");
		if(userService.findPhone(user_number)) {
			response.getWriter().write(JSON.toJSONString("手机号已被注册"));
		} else {
			response.getWriter().write(JSON.toJSONString(""));
		}
	}
	/**
	 * 发送手机验证码
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
				response.getWriter().write(JSON.toJSONString("发送失败"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 验证手机验证码
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
				System.out.println("手机号码验证成功！");
				response.getWriter().write(JSON.toJSONString(""));
			}else{
				System.out.println("手机号码验证失败！");
				response.getWriter().write(JSON.toJSONString("验证码错误"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//注册
	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String user_number = request.getParameter("phone");
		String password = request.getParameter("password");
		if(user_number != null && password != null) {
			User user = new User();
			user.setUser_number(user_number);
			user.setUser_password(password);
			if(userService.register(user) == -1) {
				System.out.println("注册失败");
			}else {
				request.getSession().setAttribute("user", user);
				response.getWriter().write(JSON.toJSONString("注册成功"));
			}
		}
	}
}
