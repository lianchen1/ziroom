package util;

import java.util.List;
import java.util.Map;


public class PageUtil {
	public Integer index;
	public Integer page;//每页条数
	public Integer totalPage;//总页数
	public Integer totalRecouds ;//总条数
	public List<Map<String, Object>> list;
	public Integer getIndex() {
		return index;
	}
	public Integer getPage() {
		return page;
	}
	
	public Integer getTotalPage() {
		return totalPage;
	}
	public Integer getTotalRecouds() {
		return totalRecouds;
	}
	public List<Map<String, Object>> getList() {
		return list;
	}
	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public void setTotalRecouds(Integer totalRecouds) {
		this.totalRecouds = totalRecouds;
	}
	
}
