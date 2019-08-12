package com.hyg.controller.table;

import com.hyg.pojo.User;
import com.hyg.service.UserService;
import com.hyg.util.RespondJson;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController
{
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	/**
	 * 获得用户表中的所有数据
	 * @return
	 */
	@GetMapping("/selectData/getUserData")
	@ResponseBody
	public RespondJson<User> getUserData()
	{
		return userService.getUserData();
	}

	/**
	 * 用户添加
	 * 前端传过来的数据：用户名、密码、手机、邮箱、性别
	 * @param user 用户数据包含明文密码
	 * @return
	 */
	@PostMapping("/insertData/addOneUser")
	@ResponseBody
	public boolean addOneUser(User user)
	{
		return userService.dealUserReg(user);
	}

	/**
	 * 用户登录接口
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping("/userLogin")
	public String userLogin(User user, Model model)
	{
		int flag = userService.dealUserLogin(user);

		if (flag == 0) // 用户不存在
		{
			model.addAttribute("res", "用户不存在");
			return "base/login";
		}
		else if (flag == 1) // 用户存在但密码错误
		{
			model.addAttribute("res", "密码错误");
			return "base/login";
		}
		else if (flag == 2) // 登录成功
		{
			return "index";
		}
		else
		{
			model.addAttribute("res", "出现未知错误");
			return "base/login";
		}
	}

	/**
	 * 退出登录
	 * @return
	 */
	@GetMapping("/userLogout")
	public String userLogout()
	{
		SecurityUtils.getSubject().logout();
		return "base/login";
	}
}