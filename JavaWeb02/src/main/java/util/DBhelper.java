package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBhelper {
	 static String driver = "com.mysql.jdbc.Driver";
	 static String url = "jdbc:mysql://127.0.0.1:3306/invitation";
	 static String user = "root";
	 static String passowrd = "951123";
	 static{
		 try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 static public Connection getCon(Connection con){
		 try {
			con = DriverManager.getConnection(url,user,passowrd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	 }
	 static public void closeAll(Connection con ,ResultSet rs ,PreparedStatement pstm){
		 try {
			if (con != null) {
				con.close();
			}if (rs != null) {
				rs.close();
			}if (pstm != null) {
				pstm.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
}
