package com.hyg.controller;

import com.alibaba.fastjson.JSON;
import com.hyg.pojo.User;
import com.hyg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController
{
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	/**
	 * 测试
	 * 返回所有用户的所有数据
	 * 返回的数据类型是json
	 * @return
	 */
	@GetMapping("/getUserData")
	@ResponseBody
	public List<User> getUserData()
	{
		return userService.listUsers();
	}

	/**
	 * 用户注册接口
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
}