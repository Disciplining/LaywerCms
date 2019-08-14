package com.hyg.shiro;

import com.hyg.mapper.UserMapper;
import com.hyg.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;
import java.util.HashSet;

public class UserRealm extends AuthorizingRealm
{
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	/**
	 * 执行授权逻辑
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
	{
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal(); //获得当前登录的用户

		//获得当前登录用户的角色并处理成一个集合
		String[] roleArr = user.getRole().split("\\s+");

		Collection<String> roles = new HashSet<>(roleArr.length);
		for (String role : roleArr)
		{
			roles.add(role);
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); //创建一个这样的对象，它是返回的类型的子类
		info.addRoles(roles); //为当前用户关联角色

		return info;
	}

	/**
	 * 执行认证逻辑
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
	{
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

		String intpuLoginName = token.getUsername(); // 用户输入的用户名
		User userInDatabase = userMapper.getOneUserByName(intpuLoginName); // 数据库中的用户（可能为空）

		if (userInDatabase == null)
		{
			return null;
		}

		return new SimpleAuthenticationInfo(userInDatabase, userInDatabase.getPassword(), "");
	}
}