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
	private String description;
	//所属公司
	private Long companyId;
	//部门经理
	private Long managerId;
	
	public Long getCompanyId() {
		return companyId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public String getDescription() {
		return description;
	}
	public Long getId() {
		return id;
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
}
