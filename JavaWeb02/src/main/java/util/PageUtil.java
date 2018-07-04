package util;

import java.util.List;
import java.util.Map;


public class PageUtil {
	public Integer index;
	public Integer page;//每页条数
	public Integer totalPage;//总页数
	public Integer totalRecouds ;//总条数
	public List<Map<String, Object>> books;
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
	public List<Map<String, Object>> getBooks() {
		return books;
	}
}
