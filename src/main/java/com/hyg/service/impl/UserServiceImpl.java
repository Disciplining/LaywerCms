package com.hyg.service.impl;

import com.hyg.mapper.UserMapper;
import com.hyg.pojo.User;
import com.hyg.service.UserService;
import com.hyg.shiro.UserRole;
import com.hyg.util.RespondJson;
import com.hyg.util.UserUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
	 * 获得符合前端格式的
	 * 用户表的数据
	 *
	 * @return
	 */
	@Override
	public RespondJson<User> getUserData()
	{
		List<User> list = userMapper.listUsers();

		RespondJson<User> json = new RespondJson<>();

		json.setCode(0);
		json.setMsg(null);
		json.setCount(list.size());
		json.setData(list);

		return json;
	}

	/**
	 * 用户注册逻辑
	 *
	 * @param user 用户数据包含明文密码
	 * @return
	 */
	@Override
	public boolean dealUserReg(User user)
	{
		if (user.getLoginName() == null || user.getPassword() == null)
		{
			return false;
		}

		// 加密用户密码
		user.setPassword(UserUtil.getEncryptPassword(user.getPassword()));

		// 前端没人传过来的数据
		user.setDeleteFlag("0");
		user.setRole(UserRole.COMMON_USER);

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

	/**
	 * 用户登录逻辑
	 * 0 : 用户不存在
	 * 1 ： 用户存在但密码错误
	 * 2 ： 登录成功
	 * @param user 用户登录时输入的信息 包含输入的密码的明文
	 * @return
	 */
	@Override
	public int dealUserLogin(User user)
	{
		String encryInputPassword = UserUtil.getEncryptPassword(user.getPassword()); // 用户输入的密码对应的密文
		user.setPassword(encryInputPassword);

		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());

		try
		{
			subject.login(token);
		}
		catch (UnknownAccountException e) //抛出这个异常说明用户不存在
		{
			return 0;
		}
		catch (IncorrectCredentialsException e) //抛出这个异常说明密码错误
		{

			return 1;
		}


		return 2;
	}
}