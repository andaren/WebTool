package com.zxjyTools.entity;

public class TeacherAtt {

	private Long id;//老师考勤表ID
	private String checkId;//考勤时间名称id
	private String username;//老师talkID
	private String teacherId;//老师ID
	private String checkName;//考勤时间段名称
	private String checkTime;
	private String status;//考勤结果 1：正常签到，2：迟到，3：未签到，4：正常签退,5：早退，6：未签退
	private String schoolId;
	private String isReader;
	private String flag;
	//----------------------------------------------------------------------------
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCheckId() {
		return checkId;
	}
	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getCheckName() {
		return checkName;
	}
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getIsReader() {
		return isReader;
	}
	public void setIsReader(String isReader) {
		this.isReader = isReader;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
