package service;

import dao.UserDAO;
import entity.User;

public class UserService {
	UserDAO userDAO = new UserDAO();
	/**
	 * 查询手机号是否存在
	 *  ture代表已存在
	 */
	public boolean findPhone(String phoneNum) {
		return userDAO.findPhone(phoneNum);
	}
	
	/**
	 * 注册
	 * 返回-1注册失败
	 */
	public int register(User user) {
		return userDAO.register(user);
	}
	/**
	 * 登录，返回一个用户
	 * 异常就是登录失败
	 * @throws Exception 
	 */
	public User login(String user_code,String password) throws Exception {
		return userDAO.login(user_code, password);
	}
}
