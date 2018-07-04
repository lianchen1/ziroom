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
	//����ɾ����
	public int updateData(String sql,List<Object> lists) {
		//��ȡpstm
		this.getPstm(sql, lists);
		//������޸��˶����С�����
		int result = -1;
		try {
			//���ò������ݿ�ķ���
			result = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�������ʱ-1����û��������������ɹ��ˣ�
		return result;
	}
	//��ѯ������list���ϣ���Ŷ����б�
	public List<T> selectData(String sql,List<Object> lists,Class clazz){
		List<T> list = new ArrayList<T>();
		this.getPstm(sql, lists);
		try {
			//�������ݿ�
			rs = pstm.executeQuery();
			//�õ����ݿ�����ݼ�
			ResultSetMetaData rsmd = rs.getMetaData();
			//�õ����ݼ�һ��������
			int column = rsmd.getColumnCount();
			//����һ�������ݵ�ʱ��
			while (rs.next()) {
				//����һ������clazz���͵Ķ����൱�ڴ�������һ�еĵĶ���
				Object obj = clazz.newInstance();
				for (int i = 1; i <= column ; i++) {
					//�õ�ÿһ�е��ֶ���
					String columnName = rsmd.getColumnName(i);
					//�õ���Ӧ�ֶ�����ֵ
					Field field = clazz.getDeclaredField(columnName);
					//���÷��佫�õ���ֵ���ֶ���ת����set����д�봴����obj�����У����obj����ͺ����ݿ�ÿһ��һһ��Ӧ���õ����ֶ�������ĸ��дǰ�����set���Ƕ����set����
					Method method = clazz.getDeclaredMethod("set"+columnName.substring(0, 1).toUpperCase()+columnName.substring(1), field.getType());
					//���øոյõ��ķ�������ֵset��obj����
					method.invoke(obj, rs.getObject(columnName));
				}
				//����list����
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
