package com.hyg.shiro;

import com.hyg.mapper.UserMapper;
import com.hyg.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
		System.out.println("执行授权逻辑");
		return null;
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
		User userInDatabase = userMapper.getOneUser(intpuLoginName); // 数据库中的用户（可能为空）

		if (userInDatabase == null)
		{
			return null;
		}

		return new SimpleAuthenticationInfo(userInDatabase, userInDatabase.getPassword(), "");
	}
}