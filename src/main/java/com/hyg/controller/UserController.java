package com.hyg.controller;

import com.hyg.pojo.User;
import com.hyg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}