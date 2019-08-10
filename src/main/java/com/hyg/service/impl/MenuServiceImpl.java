package com.hyg.service.impl;

import com.hyg.mapper.MenuMapper;
import com.hyg.pojo.Menu;
import com.hyg.service.MenuService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService
{
	@Autowired
	@Qualifier("menuMapper")
	private MenuMapper menuMapper;

	/**
	 * 获得符合前端格式的
	 * menu表的数据
	 *
	 * @return
	 */
	@Override
	public RespondJson<Menu> getMenuData()
	{
		List<Menu> list = menuMapper.listMenus();

		RespondJson<Menu> json = new RespondJson<>();

		json.setCode(0);
		json.setMsg(null);
		json.setCount(list.size());
		json.setData(list);

		return json;
	}
}