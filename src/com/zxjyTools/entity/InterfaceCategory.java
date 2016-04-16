package com.zxjyTools.entity;

import java.io.Serializable;

/**
 * 接口类型类
 * @author Administrator
 *
 */
public class InterfaceCategory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer parentId;
	private String type;
	private String actionName;
	private int flag;
	
	public InterfaceCategory() {
		
	}

	//---------------------------------------------
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
