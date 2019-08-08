package com.hyg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通用控制器
 */
@Controller
public class CommonController
{
	/**
	 *  测试
	 * @return
	 */
	@GetMapping("/test")
	@ResponseBody
	public String test()
	{
		return "success 123";
	}

	/**
	 * 设置首页
	 * @return
	 */
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
}