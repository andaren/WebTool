package com.zxjyTools.vo;

public class InterfaceVo {
//	<td>�ӿ�ID</td>	
//	<td>�ӿ���</td>
//	<td>�ӿ�Action</td>
//	<td>�ӿ�����</td>
//	<td>�ӿ�����</td>			
//	<td>����·��</td>
//	<td>�������</td>
//	<td>�ύ��</td>
//	<td>����</td>
	private Integer interfaceId;
	private String interfaceName;
	private String actionName;
	private String interfaceType;
	private String description;
	private String interfacePath;
	private String submitter;
	private String interfaceArgs;
	
	public InterfaceVo() {
		
	}
	
	//-----------------------------------------------------------------------------
	public InterfaceVo(Integer interfaceId, String interfaceName,
			String actionName, String interfaceType, String description,
			String interfacePath, String submitter, String interfaceArgs) {
		super();
		this.interfaceId = interfaceId;
		this.interfaceName = interfaceName;
		this.actionName = actionName;
		this.interfaceType = interfaceType;
		this.description = description;
		this.interfacePath = interfacePath;
		this.submitter = submitter;
		this.interfaceArgs = interfaceArgs;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInterfacePath() {
		return interfacePath;
	}

	public void setInterfacePath(String interfacePath) {
		this.interfacePath = interfacePath;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public String getInterfaceArgs() {
		return interfaceArgs;
	}

	public void setInterfaceArgs(String interfaceArgs) {
		this.interfaceArgs = interfaceArgs;
	}

	public Integer getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(Integer interfaceId) {
		this.interfaceId = interfaceId;
	}
	
	
}
