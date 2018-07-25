package com.xiaotong.shopping.admin.bean.role;

import java.io.Serializable;

public class Role implements Serializable{
	/**
	 * 角色主键
	 */
	private Integer role_id;
	private String role_name;//角色名称
	private String description;
	private String sorting;
	private String auth_size;
	private Integer auth_id;
	public Role() {
		super();
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSorting() {
		return sorting;
	}
	public void setSorting(String sorting) {
		this.sorting = sorting;
	}
	public String getAuth_size() {
		return auth_size;
	}
	public void setAuth_size(String auth_size) {
		this.auth_size = auth_size;
	}
	public Integer getAuth_id() {
		return auth_id;
	}
	public void setAuth_id(Integer auth_id) {
		this.auth_id = auth_id;
	}
	public Role(Integer role_id, String role_name, String description,
                String sorting, String auth_size, Integer auth_id) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.description = description;
		this.sorting = sorting;
		this.auth_size = auth_size;
		this.auth_id = auth_id;
	}
	

}
