package com.hyg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 通用控制器
 */
@Controller
public class CommonController
{
	/**
	 * 设置首页
	 * @return
	 */
	@GetMapping("/")
	public String index()
	{
		return "test";
	}
}