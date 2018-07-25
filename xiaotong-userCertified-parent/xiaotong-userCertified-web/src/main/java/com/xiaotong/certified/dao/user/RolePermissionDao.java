package com.xiaotong.certified.dao.user;

import com.xiaotong.certified.bean.user.RolePermission;

public interface RolePermissionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}