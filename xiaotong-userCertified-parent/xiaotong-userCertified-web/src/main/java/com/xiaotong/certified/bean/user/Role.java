package com.xiaotong.certified.bean.user;

import java.io.Serializable;

public class Role implements Serializable{
    private Integer id;

    private String name;

    private Integer sort;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", sort=" + sort + "]";
	}


}