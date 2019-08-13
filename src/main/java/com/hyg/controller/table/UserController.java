package com.hyg.controller.table;

import com.alibaba.fastjson.JSON;
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
import org.springframework.web.bind.annotation.RequestBody;
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
	 * 用户添加接口 接口json数据
	 * 使用这个接口向数据库中添加用户 不提供前端页面
	 * 后期注释掉这个接口
	 * @param jsonData 用户数据包含明文密码
	 * @return
	 */
	@PostMapping("/userReg")
	@ResponseBody
	public boolean userReg(@RequestBody String jsonData)
	{
		User user = JSON.parseObject(jsonData, User.class);

		return userService.dealUserReg(user);
	}

	/**
	 * 普通管理员用户添加接口 接收表单数据
	 * 超级管理员才有权限添加用户
	 * 前端传过来的数据：密码、登录名、真实姓名、性别、手机、邮箱、职位
	 * @param user 用户数据包含明文密码
	 * @return
	 */
	@PostMapping("/root/addOneUser")
	public String addOneUser(User user, Model model)
	{
		if (userService.dealUserReg(user))
		{
			return "base/userMgr";
		}
		else
		{
			model.addAttribute("res", "添加用户失败");
			return "base/addUser";
		}
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