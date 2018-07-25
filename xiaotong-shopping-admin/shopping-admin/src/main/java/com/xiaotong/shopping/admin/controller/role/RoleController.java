package com.xiaotong.shopping.admin.controller.role;

import com.xiaotong.shopping.admin.bean.role.Role;
import com.xiaotong.shopping.admin.dto.role.RoleDTO;
import com.xiaotong.shopping.admin.service.role.RoleService;
import com.xiaotong.utils.ReturnUtils;
import com.xiaotong.utils.StateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping(value="/AppRole")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	public Map<Object, Object> findRoleById(Integer role_id){
		if(role_id == null){
			return ReturnUtils.returnApp(StateCodeUtils.FAILURE,
					"参数不能为空", null);
		}
		Role role = roleService.findRoleById(role_id);
		RoleDTO roledto = new RoleDTO();
		roledto.setRole_name(role.getRole_name());
		return ReturnUtils.returnApp(StateCodeUtils.SUCCESS, "成功", roledto);
		
	}
	

}
