package com.hyg.controller;

import com.hyg.service.ExampleService;
import com.hyg.util.ExampleRep;
import com.hyg.util.JsonRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController
{
	@Autowired
	@Qualifier("exampleServiceImpl")
	private ExampleService exampleService;

	@GetMapping("/getArticleData")
	@ResponseBody
	public JsonRep<ExampleRep> getExampleData()
	{
		return exampleService.getExampleData();
	}
}