package com.xiaotong.certified.service;

import java.sql.SQLException;
import java.util.Map;

import com.xiaotong.certified.bean.user.User;

public interface UserService {

	User getUser(int userId);

	void addUser(User user)throws SQLException;

	void deleteUser(int userId)throws SQLException;

	void updateUser(User user)throws SQLException;

	/**
	 * @description 获取用户信息
	 * @author wchuang
	 * @time 2016年8月22日 下午12:01:15
	 */
	User getUserByAccount(String account);

	Map<Object, Object> authenticat(String account, String password);

}
