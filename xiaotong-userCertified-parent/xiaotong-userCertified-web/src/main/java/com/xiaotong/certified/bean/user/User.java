package com.xiaotong.certified.bean.user;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private Integer id;

	private String account;

	private String password;

	private String username;


	private Integer phone;

	private Date created;
	
	private Date loginTime;
	
	private Date outLoginTime;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", username=" + username
				+ ", phone=" + phone + ", created=" + created + ", loginTime=" + loginTime + ", outLoginTime="
				+ outLoginTime + "]";
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getOutLoginTime() {
		return outLoginTime;
	}

	public void setOutLoginTime(Date outLoginTime) {
		this.outLoginTime = outLoginTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}