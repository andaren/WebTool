package com.zxjyTools.entity;

public class TimeSchedual {

	private Long id;
	private String checkName;
	private String startTime;
	private String workTime;
	private String endTime;
	//private String mustSign;
	//private String delayTime;
	//private String usingFlag;
	private String schoolId;
	private String offStartTime;
	private String offTime;
	private String offEndTime;
	//private String offDelayTime;
	//private String flag;
	//private String offMustSign;
	private String worksetId;
	//--------------------------------------------------
	
	public Long getId() {
		return id;
	}
	public void setIdbig(Long id) {
		this.id = id;
	}
	public String getCheckName() {
		return checkName;
	}
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getOffStartTime() {
		return offStartTime;
	}
	public void setOffStartTime(String offStartTime) {
		this.offStartTime = offStartTime;
	}
	public String getOffTime() {
		return offTime;
	}
	public void setOffTime(String offTime) {
		this.offTime = offTime;
	}
	public String getOffEndTime() {
		return offEndTime;
	}
	public void setOffEndTime(String offEndTime) {
		this.offEndTime = offEndTime;
	}
	public String getWorksetId() {
		return worksetId;
	}
	public void setWorksetId(String worksetId) {
		this.worksetId = worksetId;
	}
	
}
