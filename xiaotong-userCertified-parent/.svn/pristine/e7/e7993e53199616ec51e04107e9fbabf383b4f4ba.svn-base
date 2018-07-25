package com.xiaotong.certified.dao.user;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;

import com.xiaotong.certified.bean.user.User;

public interface UserDao {
    int deleteByPrimaryKey(Integer id)throws SQLException;

    int insert(User record)throws SQLException;

    int insertSelective(User record)throws SQLException;

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record)throws SQLException;

    int updateByPrimaryKey(User record)throws SQLException;
    
    User getUserByAccount(@Param("account")String account);
}