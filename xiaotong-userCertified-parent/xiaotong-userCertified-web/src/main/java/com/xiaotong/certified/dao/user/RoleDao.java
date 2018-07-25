package com.xiaotong.certified.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaotong.certified.bean.user.Role;

public interface RoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<String> getRoles(@Param("account")String account);
}