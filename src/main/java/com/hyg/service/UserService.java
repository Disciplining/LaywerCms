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
}