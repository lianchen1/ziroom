package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.Invitation;

public class InvitationDAO extends BaseDAO<Invitation>{
	public List<Map<String, Object>> showInvit(String InvitName,int index,int page){
		String sql = "select * from invitation ";
		List<Object> lists = new ArrayList<Object>();
		if (InvitName != null && InvitName !="") {
			sql += "where title like concat('%',?,'%')";
			lists.add(InvitName);
		}
		sql += " limit "+index*page+", "+page;
		return super.selectDatas(sql, lists);
	}
	public int getCount(String invitName) {
		String sql = "select count(1) count from invitation";
		List<Object> lists = new ArrayList<Object>();
		if (invitName != null && invitName !="") {
			sql += " where title like concat('%',?,'%')";
			lists.add(invitName);
		}
		return Integer.valueOf (super.selectDatas(sql, lists).get(0).get("count").toString());
	}
	public static void main(String[] args) {
		InvitationDAO id = new InvitationDAO();
		System.out.println(id.getCount(null));
	}
	public int delInvit(int invitId) {
		String sql = "DELETE FROM invitation WHERE id = ? ";
		List<Object> lists = new ArrayList<Object>();
		lists.add(invitId);
		return super.useData(sql, lists);
	}
}
