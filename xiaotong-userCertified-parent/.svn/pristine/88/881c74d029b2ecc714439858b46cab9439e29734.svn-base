package com.xiaotong.certified.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaotong.certified.bean.user.Permission;

public interface PermissionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
     
    List<String> getPermissions(@Param("account")String account,@Param("url")String url);
}