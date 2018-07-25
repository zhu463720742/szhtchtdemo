package com.xiaotong.certified.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotong.certified.bean.user.User;
import com.xiaotong.certified.service.RedisService;
import com.xiaotong.certified.service.UserService;
import com.xiaotong.certified.utils.ReturnUtils;
import com.xiaotong.certified.utils.StateCodeUtils;
import com.xiaotong.certified.utils.VerifyCodeUtils;

/**
 * 
 * <p>
 * Title: LoginController
 * </p>
 * <p>
 * Description: 登陆和退出
 * </p>
 * <p>
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private RedisService redisService;

	// 用户登陆提交方法
	/**
	 * 
	 * <p>
	 * Title: login
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param session
	 * @param randomcode
	 *            输入的验证码
	 * @param usercode
	 *            用户账号
	 * @param password
	 *            用户密码
	 * @return
	 * @throws Exception
	 */
	
	// 验证码
		@RequestMapping("/login")
		public String login() {
			return "login/login";

		}
	
		// 验证码
				@RequestMapping("/index")
				public String index() {
					return "login/index";

				}
	
	@RequestMapping("/doLogin")
	@ResponseBody
	public Map<Object, Object> login(String randomcode, String account, String password) {

		if ( account == null && password == null) {
			return ReturnUtils.returnApp(StateCodeUtils.MISSING_PARAMETERS, "缺少必要参数", null);
		}
		// 校验验证码，防止恶性攻击
		// 从session获取正确验证码
		String randomcode2 = redisService.getRandomcode(randomcode);

		// 输入的验证和session中的验证进行对比
		/*if (!randomcode.equals(randomcode2)) {
			// 抛出异常
			return ReturnUtils.returnApp(StateCodeUtils.RANDOM_CODE, "验证码错误", null);
		}*/
		Map<Object, Object> authenticat = userService.authenticat(account, password);
		return authenticat;
	}

	@RequestMapping("/registered")
	@ResponseBody
	public Map<Object, Object> registered( String account, String password) {

		if (account == null && password == null) {
			return ReturnUtils.ajaxReturn(StateCodeUtils.MISSING_PARAMETERS, "缺少必要参数");
		}
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		try {
			userService.addUser(user);
			return ReturnUtils.ajaxReturn(StateCodeUtils.SUCCESS, "注册成功");
		} catch (SQLException e) {
			e.printStackTrace();
			return ReturnUtils.ajaxReturn(StateCodeUtils.FAILURE, "注册失败");
		}
	}
	
	
	
	
	
	// 验证码
	@RequestMapping("/randomcode")
	@ResponseBody
	public String randomcode() {
		String code = VerifyCodeUtils.generateVerifyCode(4);
		redisService.setRandomcode(code, code, 1);
		return code;

	}

	// 用户退出
	@RequestMapping("/logout")
	public String logout(Integer userId) {
		redisService.delToken(userId);
		return "login/login";

	}

}
