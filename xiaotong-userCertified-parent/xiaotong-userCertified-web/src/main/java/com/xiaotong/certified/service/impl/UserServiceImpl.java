package com.xiaotong.certified.service.impl;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaotong.certified.bean.user.ActiveUser;
import com.xiaotong.certified.bean.user.User;
import com.xiaotong.certified.dao.user.UserDao;
import com.xiaotong.certified.service.RedisService;
import com.xiaotong.certified.service.UserService;
import com.xiaotong.certified.utils.MD5;
import com.xiaotong.certified.utils.ReturnUtils;
import com.xiaotong.certified.utils.StateCodeUtils;

@Service()
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RedisService redisService;

	@Override
	public User getUser(int userId) {

		return userDao.selectByPrimaryKey(userId);
	}

	@Override
	public void addUser(User user) throws SQLException {
		String password_input_md5 = new MD5().getMD5ofStr(user.getPassword());
		user.setPassword(password_input_md5);
		userDao.insert(user);
	}

	@Override
	public void deleteUser(int userId) throws SQLException {

		userDao.deleteByPrimaryKey(userId);
	}

	@Override
	public void updateUser(User user) throws SQLException {

		userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public User getUserByAccount(String account) {

		return userDao.getUserByAccount(account);
	}

	@Override
	public Map<Object, Object> authenticat(String account, String password) {

		/*
		 * 认证过程： 根据用户身份（账号）查询数据库，如果查询不到用户不存在 对输入的密码 和数据库密码 进行比对，如果一致，认证通过
		 */
		// 根据用户账号查询数据库
		User user = this.getUserByAccount(account);
		if (user == null) {
			// 抛出异常
			return ReturnUtils.returnApp(StateCodeUtils.USER_NOT_EXIST, "账号不存在", null);
		}
		// 数据库密码 (md5密码 )
		String password_db = user.getPassword();
		// 对输入的密码 和数据库密码 进行比对，如果一致，认证通过
		// 对页面输入的密码 进行md5加密
		String password_input_md5 = new MD5().getMD5ofStr(password);
		if (!password_input_md5.equalsIgnoreCase(password_db)) {
			// 抛出异常
			return ReturnUtils.returnApp(StateCodeUtils.PASSWORD_WRONG, "密码错误", null);
		}
		String token = redisService.getToken(user.getId());
		if (token == null) {
			redisService.delToken(user.getId());
		}
		redisService.setToken(user.getId(), 60);
		String token2 = redisService.getToken(user.getId());
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid(user.getId());
		activeUser.setAccount(user.getAccount());
		activeUser.setToken(token2);
		activeUser.setUsername(user.getUsername());
		return ReturnUtils.returnApp(StateCodeUtils.SUCCESS, "登录成功", activeUser);
	}

}
