package onlyfun.js.model;

import java.util.Date;

/**
 * @Description : 日志
 * @Creator Justin
 * @Create date : Aug 26, 2013 11:34:50 AM
 */
public class Record {
	private Long id;
	private Long employeeId;
	//提交日期
	private Date submitDate;
	//项目简称 --project abbreviation
	private String projectAbbr;
	//项目阶段
	private String projectStage;
	//计划类型
	private String planType;
	//任务类型
	private String taskType;
	//任务描述
	private String taskDesc;
	//开始日期
	private Date beginDate;
	//结束日期
	private Date endDate;
	//正常工时
	private Double normalHours;
	//加班工时
	private Double overTimeHours;
	//投入工时合计
	private Double totalHours;
	//是否完成
	private Boolean isFinished;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public String getProjectAbbr() {
		return projectAbbr;
	}
	public void setProjectAbbr(String projectAbbr) {
		this.projectAbbr = projectAbbr;
	}
	public String getProjectStage() {
		return projectStage;
	}
	public void setProjectStage(String projectStage) {
		this.projectStage = projectStage;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Double getNormalHours() {
		return normalHours;
	}
	public void setNormalHours(Double normalHours) {
		this.normalHours = normalHours;
	}
	public Double getOverTimeHours() {
		return overTimeHours;
	}
	public void setOverTimeHours(Double overTimeHours) {
		this.overTimeHours = overTimeHours;
	}
	public Double getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}
	public Boolean getIsFinished() {
		return isFinished;
	}
	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
	}
	public String getCompletionDesc() {
		return completionDesc;
	}
	public void setCompletionDesc(String completionDesc) {
		this.completionDesc = completionDesc;
	}
	//完成情况描述 Completion Description
	private String completionDesc;
}
