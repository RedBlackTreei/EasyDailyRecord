package onlyfun.js.model;

/**
 * 
 * @Description : 公司
 * @Creator Justin
 * @Create date : Aug 26, 2013 10:41:43 AM
 */
public class Company {
	private Long id;
	private Long name;
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getName() {
		return name;
	}
	public void setName(Long name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
