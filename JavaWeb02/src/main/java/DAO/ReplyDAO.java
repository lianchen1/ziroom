package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import entity.Reply_detail;

public class ReplyDAO extends BaseDAO<Reply_detail>{
	public List<Map<String, Object>> showDetail(String invitId,int index,int page){
		String sql = "select * from reply_detail where invid = ?";
		List<Object> lists = new ArrayList<Object>();
		lists.add(invitId);
		sql += " limit "+index*page+", "+page;
		return super.selectDatas(sql, lists);
	}
	public int getCount(String invitId) {
		String sql = "select count(1) count from reply_detail";
		List<Object> lists = new ArrayList<Object>();
		if (invitId != null && invitId !="") {
			sql += " where invid = ?";
			lists.add(invitId);
		}
		return Integer.valueOf (super.selectDatas(sql, lists).get(0).get("count").toString());
	}
	public int delDetail(int invitId) {
		String sql = "DELETE FROM reply_detail WHERE invid = ? ";
		List<Object> lists = new ArrayList<Object>();
		lists.add(invitId);
		return super.useData(sql, lists);
	}
	public int writeDetail(Reply_detail reply_detail) {
		String content = reply_detail.getContent();
		String author = reply_detail.getAuthor();
		int invid = reply_detail.getInvid();
		String sql = "insert into reply_detail (invid,content,author,createdate) values(?,?,?,?)";
		List<Object> lists = new ArrayList<Object>();
		lists.add(invid);
		lists.add(content);
		lists.add(author);
		lists.add(new Date());
		return super.useData(sql, lists);
	}
}
