package com.hyg.service;

import com.hyg.pojo.Menu;
import com.hyg.util.RespondJson;

public interface MenuService
{
	/**
	 * 获得符合前端格式的
	 * menu表的数据
	 * @return
	 */
	RespondJson<Menu> getMenuData();

	/**
	 * 添加一个父级菜单
	 * 前端传过来的数据：menuName、router
	 * @param menu
	 * @return
	 */
	boolean insertOneFatherMenu(Menu menu);
}