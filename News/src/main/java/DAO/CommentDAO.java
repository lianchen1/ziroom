package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import entity.News_comment;

public class CommentDAO extends BaseDAO<News_comment> {
	public List<Map<String, Object>> getCom(String comId,Integer index,Integer pageNum){
		String sql = "select * from news_comment where newsid = ?";
		List<Object> lists = new ArrayList<Object>();
		lists.add(comId);
		sql += " limit "+index+", "+pageNum;
		return super.selectDates(sql, lists);
	}
	public int getPage(String comId) {
		List<Object> lists = new ArrayList<Object>();
		String sql = "select count(1) count from news_comment";
		if(comId != null && comId != "") {
			sql += " where newsid = ?";
			lists.add(comId);
		}
		return Integer.valueOf (super.selectDates(sql, lists).get(0).get("count").toString());
	}
	public int writeCom(News_comment com) {
		List<Object> lists = new ArrayList<Object>();
		String sql = "insert into news_comment(newsid,content,author,createdate) values(?,?,?,?)";
		lists.add(com.getNewsid());
		lists.add(com.getContent());
		lists.add(com.getAuthor());
		lists.add(new Date());
		return super.updateData(sql, lists);
	}
}
