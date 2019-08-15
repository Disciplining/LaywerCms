package com.hyg.controller.table;

import com.hyg.pojo.Lawyer;
import com.hyg.pojo.LawyerExpand;
import com.hyg.service.LawyerService;
import com.hyg.shiro.PermissionPrefix;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LawyerController
{
	@Autowired
	@Qualifier("lawyerServiceImpl")
	private LawyerService lawyerService;

	/*===================================================*/

	/**
	 * 添加一个律师
	 * @param lawyerExpand
	 * @param model
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.INSERT_DATA + "/lawyer")
	public String insertOneLawyer(LawyerExpand lawyerExpand, Model model)
	{
		boolean successFlag = lawyerService.insertOneLawyer(lawyerExpand);

		if (successFlag)
		{
			return "base/personMgr";
		}
		else
		{
			model.addAttribute("res", "添加失败");
			return "base/addLwyer";
		}
	}

	/**
	 * 根据id删除一个律师
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.DELETE_DATA + "/lawyer")
	@ResponseBody
	public String deleteOneLawyerById(@RequestParam("id") String id)
	{
		if (lawyerService.deleteOneLawyerById(Integer.parseInt(id)))
		{
			return "success";
		}
		else
		{
			return "fail";
		}
	}

	/**
	 * 编辑一个律师
	 * @param lawyerExpand
	 * @param model
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.UPDATE_DATA + "/lawyer")
	public String editOneLawyer(LawyerExpand lawyerExpand, Model model)
	{
		boolean success = lawyerService.editOneLawyer(lawyerExpand);

		if (success)
		{
			return "base/personMgr";
		}
		else
		{
			model.addAttribute("res", "更新数据失败");
			return "base/personEdit";
		}
	}

	/**
	 * 分页数据
	 * @param lawyerName
	 * @param lawyerLevel
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/lawyerPageData")
	@ResponseBody
	public RespondJson<Lawyer> lawyerPageData
	(
		@RequestParam(value = "page", defaultValue = "1") int pageNum,
		@RequestParam(value = "limit", defaultValue = "10") int pageSize,
		@RequestParam(value = "name", defaultValue = "") String lawyerName,
		@RequestParam(value = "level", defaultValue = "") String lawyerLevel
	)
	{
		return lawyerService.listPageData(pageNum, pageSize, lawyerName, lawyerLevel);
	}

	/**
	 * 根据id获得一个律师
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/getOneLawyerById")
	@ResponseBody
	public RespondJson<Lawyer> getOneLawyerById(@RequestParam("id") int id)
	{
		return lawyerService.getOneLawyerById(id);
	}
}