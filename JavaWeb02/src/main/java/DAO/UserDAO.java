package DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Users;

public class UserDAO extends BaseDAO<Users>{
	//查询用户名是否存在
	public Users selectUserCode(String user_code){
		String sql = "select * from users where user_code = ?";
		List<Object> lists = new ArrayList<Object>();
		lists.add(user_code);
		List isUser = super.selectData(sql, lists, Users.class);
		if(isUser == null||isUser.size()==0){
			return null;
		}else{
			return super.selectData(sql, lists, Users.class).get(0);
		}
	}
	//注册
	public int register(Users user){
		if(this.selectUserCode(user.getUser_code()) == null){
			String sql = "insert into users (user_code,password,email,gender,register_time) values(?,?,?,?,?)";
			List<Object> lists = new ArrayList<Object>();
			if(!(user.getUser_code() == null)){
				lists.add(user.getUser_code());
			}if(!(user.getPassword() == null)){
				lists.add(user.getPassword());
			}if(!(user.getEmail() == null)){
				lists.add(user.getEmail());
			}if(!(user.getGender() == null)){
				lists.add(user.getGender());
			}
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String date1 = format.format(date);
			lists.add(date);
			return super.useData(sql, lists);
		}else{
			return -1;
		}
	}
	//登录
	public Map<String, Object> login(String user_code,String password){
		Map<String, Object> map = new HashMap<String, Object>();
		Users user = this.selectUserCode(user_code);
		if(user == null){
			map.put("login_error", "用户名不存在");
		}else{
			if(password.equals(user.getPassword())){
				map.put("user", user);
			}else{
				map.put("login_error", "密码不正确");
			}
		}return map;

	}
	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		Users user = new Users();
		user.setUser_code("张三");
		user.setPassword("123123");
		user.setEmail("123@qq.com");
		user.setGender("男");
		ud.register(user);
		Map map = ud.login("张三", "123123");
		System.out.println(map);
	}
}
