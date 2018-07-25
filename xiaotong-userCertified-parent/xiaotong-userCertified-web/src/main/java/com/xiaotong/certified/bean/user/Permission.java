package com.xiaotong.certified.bean.user;

import java.io.Serializable;

public class Permission implements Serializable{
	private Integer id;

	private String name;

	private String type;

	private String url;

	private String percode;

	private Integer parentid;

	private Integer sort;

	private Integer available;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPercode() {
		return percode;
	}

	public void setPercode(String percode) {
		this.percode = percode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}


	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}


	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", type=" + type + ", url=" + url + ", percode=" + percode
				+ ", parentid=" + parentid + ", sort=" + sort + ", available=" + available + "]";
	}

}