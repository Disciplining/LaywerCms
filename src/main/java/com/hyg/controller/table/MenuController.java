package com.hyg.controller.table;

import com.hyg.pojo.Menu;
import com.hyg.service.MenuService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MenuController
{
	@Autowired
	@Qualifier("menuServiceImpl")
	private MenuService menuService;

	/**
	 * 获得律师表中的所有数据
	 * @return
	 */
	@GetMapping("/selectData/getMenuData")
	@ResponseBody
	public RespondJson<Menu> getMenuData()
	{
		return menuService.getMenuData();
	}

	/**
	 * 添加一个父级菜单
	 * 前端传过来的数据：menuName、router
	 * @param menu
	 * @return
	 */
	@PostMapping("/insertData/insertOneFatherMenu")
	public String insertOneFatherMenu(Menu menu, Model model)
	{
		if (menuService.insertOneFatherMenu(menu))
		{
			return "base/menuMgr";
		}
		else
		{
			model.addAttribute("res", "插入数据失败");
			return "base/menuMgr";
		}
	}
}