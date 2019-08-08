package com.hyg.service;

import com.hyg.mapper.UserMapper;
import com.hyg.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService
{
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	/**
	 * 获得所有的登录用户 的所有字段
	 *
	 * @return
	 */
	@Override
	public List<User> listUsers()
	{
		return userMapper.listUsers();
	}
}