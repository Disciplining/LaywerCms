package com.hyg.controller.table;

import com.hyg.pojo.Lawyer;
import com.hyg.pojo.LawyerExpand;
import com.hyg.service.LawyerService;
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

	/**
	 * 获得律师表中的所有数据
	 * @return
	 */
	@GetMapping("/selectData/getLawyerData")
	@ResponseBody
	public RespondJson<Lawyer> getLawyerData()
	{
		return lawyerService.getLawyerData();
	}

	/**
	 * 添加一个律师
	 * @param lawyerExpand
	 * @param model
	 * @return
	 */
	@PostMapping("/insertData/lawyer")
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
	@GetMapping("/deleteData/lawyer")
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
	@PostMapping("/updateData/lawyer")
	@ResponseBody
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
	 * 根据律师名和律师职称搜索律师
	 * @param lawyerName
	 * @param lawyerLevel
	 * @return
	 */
	@GetMapping("/selectData/searchLawyer")
	@ResponseBody
	public RespondJson<Lawyer> listLawyersByNameAndLevel
	(
		@RequestParam(value = "name", defaultValue = "") String lawyerName,
		@RequestParam(value = "level", defaultValue = "") String lawyerLevel
	)
	{
		System.out.println("名字：" + lawyerName);
		System.out.println("职称：" + lawyerLevel);

		return lawyerService.listLawyersByNameAndLevel(lawyerName, lawyerLevel);
	}
}