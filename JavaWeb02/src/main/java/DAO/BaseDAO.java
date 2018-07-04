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
	public PreparedStatement getPstm(String sql,List<Object> lists){
		if(con == null){
			con = DBhelper.getCon(con);
		}
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
	//增删改
	public int useData(String sql,List<Object> lists){
		pstm = this.getPstm(sql, lists);
		int result = -1;
		try {
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBhelper.closeAll(null, rs, pstm);
		}
		return result;
	}
	//单表查询
	public List<T> selectData(String sql,List<Object> lists,Class clazz){
		List<T> objs = new ArrayList<T>();
		pstm = this.getPstm(sql, lists);
		System.out.println(pstm);
		try {
			rs = pstm.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while (rs.next()) {
				Object obj = clazz.newInstance();
				for (int i = 1; i <= count; i++) {
					String name = rsmd.getColumnName(i);
					Field field = clazz.getDeclaredField(name);
					Method method = clazz.getDeclaredMethod("set"+name.substring(0,1).toUpperCase()+name.substring(1),field.getType());
					method.invoke(obj, rs.getObject(name));
				}
				objs.add((T)obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBhelper.closeAll(null, rs, pstm);
		}
		return objs;
	}
	//多表查询
	public List<Map<String, Object>> selectDatas(String sql,List<Object> lists){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		pstm = this.getPstm(sql, lists);
		try {
			rs = pstm.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= count; i++) {
					String name = rsmd.getColumnName(i);
					map.put(name, rs.getObject(name));
				}
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBhelper.closeAll(null, rs, pstm);
		}
		return list;
	}
}
