package com.zxjyTools.entity;

/**
 * 接口类型类
 * @author Administrator
 *
 */
public class InterfaceCategory {

	private Integer id;
	private Integer parentId;
	private String type;
	private String ActionName;
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
		return ActionName;
	}

	public void setActionName(String actionName) {
		ActionName = actionName;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
