package util;
import java.util.List;
import java.util.Map;


public class PageUtil {
	public Integer index;//�ڼ�ҳ
	public Integer pageNum;//һҳ����
	public Integer totalNum;//һ��������
	public Integer totalPage;//һ������ҳ
	public List<Map<String, Object>> pageList;//ÿҳ������Ϣ�ļ���
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
