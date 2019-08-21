package com.hyg.controller.criminalLawServer;

import com.hyg.pojo.DefenseAdvantage;
import com.hyg.pojo.extend.DefenseAdvantageExpand;
import com.hyg.service.DefenseAdvantageService;
import com.hyg.shiro.PermissionPrefix;
import com.hyg.util.respond.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
			return "base/criminalAdvantageMgr";
		}
		else
		{
			model.addAttribute("msg", "添加数据失败");
			return "base/addCriminalAdvantageMgr";
		}
	}

	/**
	 * 编辑一条数据
	 * 前端传过来的数据：id、title、content、file
	 * @param expand
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.UPDATE_DATA + "/editOneDefenseAdvantage")
	public String editOneDefenseAdvantage(DefenseAdvantageExpand expand, Model model)
	{
		if (service.editOneDefenseAdvantage(expand))
		{
			return "base/criminalAdvantageMgr";
		}
		else
		{
			model.addAttribute("msg", "更新数据失败");
			return "base/editIntroductionArgument";
		}
	}

	/**
	 * 分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/defenseAdvantagePageData")
	@ResponseBody
	public RespondJson<DefenseAdvantage> defenseAdvantagePageData
	(
		@RequestParam(value = "page", defaultValue = "1") int pageNum,
		@RequestParam(value = "limit", defaultValue = "10") int pageSize
	)
	{
		return service.pageData(pageNum, pageSize);
	}

	/**
	 * 根据id获取一条数据
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/getOneDefenseAdvantageById")
	@ResponseBody
	public RespondJson<DefenseAdvantage> getOneDefenseAdvantageById(@RequestParam("id") int id)
	{
		return service.getOneDefenseAdvantageById(id);
	}

	/**
	 * 根据id删除一条数据
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.DELETE_DATA + "/deleteOneDefenseAdvantageById")
	@ResponseBody
	public boolean deleteOneDefenseAdvantageById(@RequestParam("id") int id)
	{
		return service.deleteOneDefenseAdvantageById(id);
	}
}