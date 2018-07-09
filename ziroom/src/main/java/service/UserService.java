package service;

import dao.UserDAO;
import entity.User;

public class UserService {
	UserDAO userDAO = new UserDAO();
	/**
	 * ��ѯ�ֻ����Ƿ����
	 *  ture�����Ѵ���
	 */
	public boolean findPhone(String phoneNum) {
		return userDAO.findPhone(phoneNum);
	}
	
	/**
	 * ע��
	 * ����-1ע��ʧ��
	 */
	public int register(User user) {
		return userDAO.register(user);
	}
	/**
	 * ��¼������һ���û�
	 * �쳣���ǵ�¼ʧ��
	 * @throws Exception 
	 */
	public User login(String user_code,String password) throws Exception {
		return userDAO.login(user_code, password);
	}
}
