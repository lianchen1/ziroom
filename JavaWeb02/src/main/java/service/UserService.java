package service;

import java.util.Map;

import entity.Users;
import DAO.UserDAO;

public class UserService {
	private UserDAO userDAO = new UserDAO();
	//ע��
	public int register(Users user){
		return userDAO.register(user);
	}
	//��¼
	public Map<String, Object> login(String user_code,String password){
		return userDAO.login(user_code, password);
	}
}
