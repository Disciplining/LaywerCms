package com.hyg.controller.criminalLawServer;

import com.hyg.pojo.Case;
import com.hyg.pojo.CaseExpand;
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

	/**
	 * 根据id获得一个案例
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/getOneCaseById")
	@ResponseBody
	public RespondJson<CaseExpand> getOneCaseById(@RequestParam("id") int id)
	{
		return service.getOneCaseById(id);
	}

	/**
	 * 根据id删除一个案例
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.DELETE_DATA + "/deleteOneCaseById")
	@ResponseBody
	public boolean deleteOneCaseById(@RequestParam("id") int id)
	{
		return service.deleteOneCaseById(id);
	}

	/**
	 * 编辑一个案例
	 * 前端传过来的数据：chargeName， id title desc process result lessions successFlag
	 * 后端需要的数据： id* chargeId title* desc* process* result* lessions* successFlag* editDate
	 * @param oneCase
	 * @param chargeName
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.UPDATE_DATA + "/editOneCase")
	public String editOneCase(Case oneCase, String chargeName, Model model)
	{
		if (service.editOneCase(oneCase, chargeName))
		{
			return "base/caseMgr";
		}
		else
		{
			model.addAttribute("msg", "更新数据失败");
			return "base/editChargeMgr";
		}
	}
}