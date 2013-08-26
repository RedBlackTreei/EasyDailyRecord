package onlyfun.js.model;

/**
 * 
 * @Description : 员工表
 * @Creator Justin
 * @Create date : Aug 26, 2013 10:29:47 AM
 */
public class Employee {
	private Long id;
	private String name;
	private String sex;
	private String email;
	//权限
	private String power;
	private Long groupId;
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
