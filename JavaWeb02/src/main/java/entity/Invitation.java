package entity;

import java.sql.Date;

public class Invitation {
	private Integer id;
	private String title;
	private String summary;
	private String author;
	private Date createdate;
	public Invitation(Integer id, String title, String summary, String author, Date createdate) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.author = author;
		this.createdate = createdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
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
	public Invitation() {
		super();
	}
	@Override
	public String toString() {
		return "Invitation [id=" + id + ", title=" + title + ", summary=" + summary + ", author=" + author
				+ ", createdate=" + createdate + "]";
	}

}
