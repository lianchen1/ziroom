package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBhelper {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/news";
	private static String user = "root";
	private static String password = "951123";
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static public Connection getCon() {
		Connection con = null;
		try {
			if(con == null) {
				con = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}
	static public void closeAll(Connection con,ResultSet rs,PreparedStatement pstm) {
		try {
			if(con != null) {
				con.close();
			}if(rs != null) {
				rs.close();
			}if(pstm != null) {
				pstm.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
