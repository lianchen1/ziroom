package entity;

import java.sql.Date;

public class Reply_detail {
	private Integer id;
	private Integer invid;
	private String content;
	private String author;
	private Date createdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getInvid() {
		return invid;
	}
	public void setInvid(Integer invid) {
		this.invid = invid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "Reply_detail [id=" + id + ", invid=" + invid + ", content=" + content + ", author=" + author
				+ ", createdate=" + createdate + "]";
	}

}
