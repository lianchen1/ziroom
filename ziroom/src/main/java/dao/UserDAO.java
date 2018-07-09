package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.User;
import util.DateUtil;

public class UserDAO extends BaseDAO<User>{
	/*
	 * 查询手机号是否存在
	 * ture代表已存在
	 */
	public boolean findPhone(String phoneNum) {
		String sql = "select user_id from user where user_number = ?";
		List<Object> lists = new ArrayList<Object>();
		lists.add(phoneNum);
		if(super.selectDates(sql, lists).isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * 注册方法
	 * @param args
	 * 返回-1没成功
	 */
	public int register(User user) {
		String sql = "insert into user (user_name,user_password,user_number,user_type,user_sex,register_time) values(?,?,?,?,?,?)";
		List<Object> lists = new ArrayList<Object>();
		lists.add(user.getUser_number());
		lists.add(user.getUser_password());
		lists.add(user.getUser_number());
		lists.add(1);
		lists.add(1);
		lists.add(new Date());
		return super.updateData(sql, lists);
	}
	/**
	 * 查询用户名是否存在
	 * ture代表已存在
	 */
	public boolean findUser_name(String user_name) {
		String sql = "select user_id from user where user_name = ?";
		List<Object> lists = new ArrayList<Object>();
		lists.add(user_name);
		if(super.selectDates(sql, lists).isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * 登录的方法
	 * 返回一个用户用来存到success里面
	 * @param args
	 * @throws Exception 
	 */
	public User login(String user_code,String password) throws Exception {
		if(this.findPhone(user_code)) {
			String sql = "select * from user where user_number = ?";
			List<Object> lists = new ArrayList<Object>();
			lists.add(user_code);
			User user = (User)super.selectData(sql, lists, User.class).get(0);
			if(password.equals(user.getUser_password())) {
				return user;
			}else {
				throw new Exception("密码错误");
			}
		}else if(this.findUser_name(user_code)) {
			String sql = "select * from user where user_name = ?";
			List<Object> lists = new ArrayList<Object>();
			lists.add(user_code);
			User user = (User)super.selectData(sql, lists, User.class).get(0);
			if(password.equals(user.getUser_password())) {
				return user;
			}else {
				throw new Exception("密码错误");
			}
		}else {
			throw new Exception("账户不存在");
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
	UserDAO ud = new UserDAO();
	User user = new User();
	user.setUser_number("18502511193");
	user.setUser_password("951123");
	try {
		System.out.println(ud.login("18502508010","19961230"));
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
