package util;

import java.util.List;
import java.util.Map;


public class PageUtil {
	public Integer index;
	public Integer page;//ÿҳ����
	public Integer totalPage;//��ҳ��
	public Integer totalRecouds ;//������
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
