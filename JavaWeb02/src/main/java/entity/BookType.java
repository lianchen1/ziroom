package entity;

public class BookType {
	private Integer id;
	private String type_name;
	@Override
	public String toString() {
		return "BookType [id=" + id + ", type_name=" + type_name + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String typeName) {
		type_name = typeName;
	}
}