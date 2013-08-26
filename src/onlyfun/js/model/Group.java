package onlyfun.js.model;

/**
 * @Description : 部门下的“组”
 * @Creator Justin
 * @Create date : 2013-08-23 5:53:19 PM
 */
public class Group {
	private Long id;
	//小组名称
	private String groupName;
	private String description;
	private Long departmentId;
	//资源组经理
	private Long managerId;
	
	public Long getDepartmentId() {
		return departmentId;
	}
	public String getDescription() {
		return description;
	}
	public String getGroupName() {
		return groupName;
	}
	public Long getId() {
		return id;
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
}
