package DAO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBhelper;

public class BaseDAO<T> {
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pstm = null;
	public PreparedStatement getPstm(String sql,List<Object> lists) {
		con = DBhelper.getCon();
		try {
			pstm = con.prepareStatement(sql);
			for (int i = 0; i < lists.size(); i++) {
				pstm.setObject(i+1, lists.get(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstm;
	}
	//增，删，改
	public int updateData(String sql,List<Object> lists) {
		//获取pstm
		this.getPstm(sql, lists);
		//结果，修改了多少行。。。
		int result = -1;
		try {
			//调用操作数据库的方法
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//如果返回时-1代表没操作，其他代表成功了，
		return result;
	}
	//查询，返回list集合（存放对象列表）
	public List<T> selectData(String sql,List<Object> lists,Class clazz){
		List<T> list = new ArrayList<T>();
		this.getPstm(sql, lists);
		try {
			//操作数据库
			rs = pstm.executeQuery();
			//得到数据库的数据集
			ResultSetMetaData rsmd = rs.getMetaData();
			//得到数据集一共多少列
			int column = rsmd.getColumnCount();
			//当下一行有数据的时候
			while (rs.next()) {
				//创建一个参数clazz类型的对象，相当于创建下面一列的的对象
				Object obj = clazz.newInstance();
				for (int i = 1; i <= column ; i++) {
					//得到每一列的字段名
					String columnName = rsmd.getColumnName(i);
					//得到对应字段名的值
					Field field = clazz.getDeclaredField(columnName);
					//利用反射将得到的值和字段名转换成set方法写入创建的obj对象中，这个obj对象就和数据库每一行一一对应，得到的字段名首字母大写前面加上set就是对象的set方法
					Method method = clazz.getDeclaredMethod("set"+columnName.substring(0, 1).toUpperCase()+columnName.substring(1), field.getType());
					//调用刚刚得到的方法，将值set入obj对象
					method.invoke(obj, rs.getObject(columnName));
				}
				//放入list集合
				list.add((T)obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBhelper.closeAll(null, rs, pstm);
		}
 		return list;
	}
	public List<Map<String, Object>> selectDates(String sql,List<Object> lists){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		this.getPstm(sql, lists);
		try {
			rs = pstm.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int column = rsmd.getColumnCount();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= column; i++) {
					String columnName = rsmd.getColumnName(i);
					map.put(columnName, rs.getObject(columnName));
				}
				list.add(map);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBhelper.closeAll(null, rs, pstm);
		}
		return list;
	}
}
