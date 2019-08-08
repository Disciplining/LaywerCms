package com.hyg.service;

import com.hyg.mapper.UserMapper;
import com.hyg.pojo.User;
import com.hyg.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
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

	/**
	 * 用户注册逻辑
	 *
	 * @param user 用户数据包含明文密码
	 * @return
	 */
	@Override
	public boolean userReg(User user)
	{
		// 加密用户密码
		user.setPassword(UserUtil.getEncryptPassword(user.getPassword()));

		try
		{
			userMapper.insertOneUser(user);
		}
		catch (DuplicateKeyException e)
		{
			// 用名重复
			return false;
		}

		return true;
	}
}