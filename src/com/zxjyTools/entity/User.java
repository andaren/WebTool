package com.zxjyTools.entity;

import java.io.Serializable;

public class User implements Serializable{

	//����ID
	private Long id;
	//�û���
	private String username;
	//����
	private String password;
	//����״̬
	private int flag;
	//��Ӧ��IP��ַ
	private String IP;

	//---------------------------------------------------------------------//
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}
	
	
	
}
