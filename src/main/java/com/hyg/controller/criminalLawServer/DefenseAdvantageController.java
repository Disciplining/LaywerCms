package com.hyg.controller.criminalLawServer;

import com.hyg.pojo.DefenseAdvantageExpand;
import com.hyg.service.DefenseAdvantageService;
import com.hyg.shiro.PermissionPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DefenseAdvantageController
{
	@Autowired
	@Qualifier("defenseAdvantageServiceImpl")
	private DefenseAdvantageService service;

	/**
	 * 添加一条数据
	 * 前端传过来的字段：title、content、file
	 * @param advantageExpand
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.INSERT_DATA + "/insertOneAdvantage")
	public String insertOneAdvantage(DefenseAdvantageExpand advantageExpand, Model model)
	{
		if (service.insertOneAdvantage(advantageExpand))
		{
			System.out.println("成功");
			return "base/criminalAdvantageMgr";
		}
		else
		{
			System.out.println("失败");
			model.addAttribute("msg", "添加数据失败");
			return "base/addCriminalAdvantageMgr";
		}
	}
}