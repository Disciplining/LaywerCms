package com.hyg.service;

import com.hyg.pojo.User;
import com.hyg.util.respond.RespondJson;

public interface UserService
{
	/**
	 * 用户注册逻辑
	 * @param user 用户数据包含明文密码
	 * @return
	 */
	boolean dealUserReg(User user);

	/**
	 * 用户登录逻辑
	 * 0 : 用户不存在
	 * 1 ： 用户存在但密码错误
	 * 2 ： 登录成功
	 * @param user 用户登录时输入的信息 包含输入的密码的明文
	 * @return
	 */
	int dealUserLogin(User user);

	/**
	 * 根据id删除一个用户（逻辑删除）
	 * @param id
	 * @return
	 */
	boolean deleteOneUserById(int id);

	/**
	 * 编辑一个普通管理员用户的信息
	 * 前端传过来的信息：用户id、登录名、真实姨名、姓别、电话、邮箱、职务
	 * @param user
	 * @return
	 */
	boolean updateOneUserById(User user);

	/**
	 * 分页数据
	 * @param pageNum
	 * @param pageSize
	 * @param userName
	 * @return
	 */
	RespondJson<User> listPageData(int pageNum, int pageSize, String userName);

	/**
	 * 根据id获得一个普通管理员用户
	 * @param id
	 * @return
	 */
	RespondJson<User> getOneUserById(int id);
}