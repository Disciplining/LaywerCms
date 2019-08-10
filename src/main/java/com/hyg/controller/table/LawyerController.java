package com.hyg.controller.table;

import com.hyg.pojo.Lawyer;
import com.hyg.service.LawyerService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/getLawyerData")
	@ResponseBody
	public RespondJson<Lawyer> getLawyerData()
	{
		return lawyerService.getLawyerData();
	}
}