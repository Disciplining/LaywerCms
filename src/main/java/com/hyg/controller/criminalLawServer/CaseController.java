package com.hyg.controller.criminalLawServer;

import com.hyg.pojo.Case;
import com.hyg.service.CaseService;
import com.hyg.shiro.PermissionPrefix;
import com.hyg.util.respond.CaseLinkageData;
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
public class CaseController
{
	@Autowired
	@Qualifier("caseServiceImpl")
	private CaseService service;

	/**
	 * 获得添加案例时的联动数据
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/getLinkageDate")
	@ResponseBody
	public RespondJson<CaseLinkageData> getLinkageDate()
	{
		return service.getLinkageDate();
	}

	/**
	 * 添加一个案例
	 * 前端传过来的数据：
	 *
	 * chargeName 罪名名称
	 *
	 * title        案例标题
	 * desc         案例介绍
	 * process      办案过程
	 * result       结果
	 * lessions     经验心得
	 * successFlag  是否成功 1:0
	 *
	 * @param oneCase
	 * @param chargeName
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.INSERT_DATA + "/insertOneCase")
	public String insertOneCase(Case oneCase, String chargeName, Model model)
	{
		if (service.insertOneCase(oneCase, chargeName))
		{
			return "base/caseMgr";
		}
		else
		{
			model.addAttribute("msg", "添加数据失败");
			return "base/addCaseMgr";
		}
	}

	/**
	 * 分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/casePageDate")
	@ResponseBody
	public RespondJson<Case> casePageDate
	(
		@RequestParam(value = "page", defaultValue = "1") int pageNum,
		@RequestParam(value = "limit", defaultValue = "10") int pageSize
	)
	{
		return service.pageDate(pageNum, pageSize);
	}
}