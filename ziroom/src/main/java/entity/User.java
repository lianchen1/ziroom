package entity;


import java.sql.Date;

import util.DateUtil;

public class User {
	private Integer user_id;
	private String user_name;
	private String user_password;
	private String user_number;
	private String user_image;
	private Integer user_type;
	private Integer user_sex;
	private Date register_time;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	public String getUser_number() {
		return user_number;
	}
	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}
	public String getUser_image() {
		return user_image;
	}
	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}
	public Integer getUser_type() {
		return user_type;
	}
	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}
	public Integer getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(Integer user_sex) {
		this.user_sex = user_sex;
	}
	
	public Date getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_number=" + user_number + ", user_image=" + user_image + ", user_type=" + user_type
				+ ", user_sex=" + user_sex + ", register_time=" + register_time + "]";
	}
	public User() {
		super();
	}
	public User(Integer user_id, String user_name, String user_password, String user_number, String user_image,
			Integer user_type, Integer user_sex, Date register_time) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_number = user_number;
		this.user_image = user_image;
		this.user_type = user_type;
		this.user_sex = user_sex;
		this.register_time = register_time;
	}
}
