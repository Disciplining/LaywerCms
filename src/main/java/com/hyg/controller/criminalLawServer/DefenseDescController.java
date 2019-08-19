package com.hyg.controller.criminalLawServer;

import com.hyg.pojo.DefenseDesc;
import com.hyg.service.DefenseDescService;
import com.hyg.shiro.PermissionPrefix;
import com.hyg.util.respond.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefenseDescController
{
	@Autowired
	@Qualifier("defenseDescServiceImpl")
	private DefenseDescService service;

	/**
	 * 获得刑辨介绍表中的数据  只有一条数据
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/listDefenseDesc")
	@ResponseBody
	public RespondJson listDefenseDesc()
	{
		return service.listDefenseDesc();
	}

	/**
	 * 更新刑辨介绍
	 * 前端传过来的数据：desc
	 * 后端需要的数据：desc、editDate
	 * @param defenseDesc
	 * @param model
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.UPDATE_DATA + "/updateDesc")
	public String updateDesc(DefenseDesc defenseDesc, Model model)
	{
		if (service.updateDesc(defenseDesc))
		{
			model.addAttribute("msg", "更新数据成功");
		}
		else
		{
			model.addAttribute("msg", "更新数据失败");
		}

		return "base/introductionArgument";
	}
}