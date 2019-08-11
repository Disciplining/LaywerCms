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
	@ResponseBody
	public String insertOneLawyer(LawyerExpand lawyerExpand, Model model)
	{
		boolean successFlag = lawyerService.insertOneLawyer(lawyerExpand);

		if (successFlag)
		{
			return "添加成功";
		}
		else
		{
			model.addAttribute("res", "添加失败");
			return "添加失败";
		}
	}
}