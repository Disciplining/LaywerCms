package com.hyg.controller;

import com.hyg.service.LawyerService;
import com.hyg.util.lead.RepObject;
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

	@GetMapping("/getLawyerData")
	@ResponseBody
	public RepObject getLawyerData()
	{
		return lawyerService.getLawyerData();
	}
}