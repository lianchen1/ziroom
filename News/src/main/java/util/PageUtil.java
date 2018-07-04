package util;
import java.util.List;
import java.util.Map;


public class PageUtil {
	public Integer index;//第几页
	public Integer pageNum;//一页几条
	public Integer totalNum;//一共多少条
	public Integer totalPage;//一共多少页
	public List<Map<String, Object>> pageList;//每页数据信息的集合
	public Integer getIndex() {
		return index;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public List<Map<String, Object>> getPageList() {
		return pageList;
	}
	@Override
	public String toString() {
		return "PageUtil [index=" + index + ", pageNum=" + pageNum + ", totalNum=" + totalNum + ", totalPage="
				+ totalPage + ", pageList=" + pageList + "]";
	}
	
}
