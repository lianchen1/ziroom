package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.News_detail;

public class NewsDAO extends BaseDAO<News_detail>{
	public List<Map<String, Object>> showNews(String newName,Integer index,Integer pageNum){
		List<Object> lists = new ArrayList<Object>();
		String sql = "select * from news_detail";
		if(newName != null && newName != "") {
			sql += " where title like concat ('%',?,'%')";
			lists.add(newName);
		}
		sql += " limit "+index+", "+pageNum;
		return super.selectDates(sql, lists);
	}
	public int getPage(String newName) {
		List<Object> lists = new ArrayList<Object>();
		String sql = "select count(1) count from news_detail";
		if(newName != null && newName != "") {
			sql += " where title like concat ('%',?,'%')";
			lists.add(newName);
		}
		return Integer.valueOf (super.selectDates(sql, lists).get(0).get("count").toString());
	}
	public int delNew(String newId) {
		List<Object> lists = new ArrayList<Object>();
		String sql = "delete from news_detail where id = ?";
		lists.add(newId);
		return super.updateData(sql, lists);
	}
	public int delCom(String newId) {
		List<Object> lists = new ArrayList<Object>();
		String sql = "delete from news_comment where newsid = ?";
		lists.add(newId);
		return super.updateData(sql, lists);
	}
}
