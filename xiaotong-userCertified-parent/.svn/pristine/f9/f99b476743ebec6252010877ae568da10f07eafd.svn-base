package com.xiaotong.certified.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaotong.certified.dao.user.PermissionDao;
import com.xiaotong.certified.dao.user.RoleDao;
import com.xiaotong.certified.service.RoleService;

@Service()
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleMapper;
	@Autowired
	private PermissionDao permissionMapper;

	@Override
	public List<String> getPermissions(String account,String url) {
		
		return permissionMapper.getPermissions(account, url);
	}

	@Override
	public List<String> getRoles(String account) {
		
		return roleMapper.getRoles(account);
	}

}
