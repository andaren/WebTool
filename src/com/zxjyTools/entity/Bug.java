package com.zxjyTools.entity;

public class Bug {

	private Long id;//主键
	
	private String description;//描述
	private String type;//类型
	private String status;//状态
	private Long submitter;//提交人
	private Long solver;//处理者
	
	//-----------------------------------------------//
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getSubmitter() {
		return submitter;
	}
	public void setSubmitter(Long submitter) {
		this.submitter = submitter;
	}
	public Long getSolver() {
		return solver;
	}
	public void setSolver(Long solver) {
		this.solver = solver;
	}
	
	
}
