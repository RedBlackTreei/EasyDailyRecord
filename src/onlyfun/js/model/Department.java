package onlyfun.js.model;

/**
 * @Description : 部门Model
 * @Creator Justin
 * @Create date : 2013-08-23 5:48:06 PM
 */
public class Department {
	private Long id;
	//部门名称
	private String departmentName;
	//经理id
	private Long managerId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
