package com.zxjyTools.entity;

/**
 * 接口实体类
 * @author Administrator
 *
 */
public class Interface {

	private Integer id;
	private Integer categoryId;
	private String name;
	private String args;
	private String path;
	private Integer flag;
	private Integer submitter;
	
	public Interface() {
		
	}

	//---------------------------------------
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getSubmitter() {
		return submitter;
	}

	public void setSubmitter(Integer submitter) {
		this.submitter = submitter;
	}
	
	
}
