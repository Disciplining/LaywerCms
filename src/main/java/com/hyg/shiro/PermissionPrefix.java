package com.hyg.shiro;

/**
 * 方便权限管理
 * url中的 前缀
 */
public class PermissionPrefix
{
	/**
	 * 增删改查数据，只能登录才能进行
	 */
	public static final String SELECT_DATA = "selectData";
	public static final String INSERT_DATA = "insertData";
	public static final String UPDATE_DATA = "updateData";
	public static final String DELETE_DATA = "deleteData";

	/**
	 * 只有拥有root 角色的用户才可以访问
	 */
	public static final String ROOT = "root";
}