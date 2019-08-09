package com.hyg.service;

import com.hyg.pojo.User;

import java.util.List;

public interface UserService
{
	/**
	 * 获得所有的登录用户 的所有字段
	 * @return
	 */
	public List<User> listUsers();

	/**
	 * 用户注册逻辑
	 * @param user 用户数据包含明文密码
	 * @return
	 */
	boolean userReg(User user);

	/**
	 * 用户登录逻辑
	 * 0 : 用户不存在
	 * 1 ： 用户存在但密码错误
	 * 2 ： 登录成功
	 * @param user 用户登录时输入的信息 包含输入的密码的明文
	 * @return
	 */
	int dealUserLogin(User user);
}