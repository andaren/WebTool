package com.zxjyTools.entity;

public class Bug {

	private Long id;//����
	
	private String description;//����
	private String type;//����
	private String status;//״̬
	private Long submitter;//�ύ��
	private Long solver;//������
	
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
