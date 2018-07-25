package com.xiaotong.shopping.admin.service.impl.role;

import com.xiaotong.shopping.admin.bean.role.Role;
import com.xiaotong.shopping.admin.dao.role.RoleDao;
import com.xiaotong.shopping.admin.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;
	@Override
	public Role findRoleById(Integer role_id) {
		Role role = roleDao.selectByPrimaryKey(role_id);
		return role;
	}

}
