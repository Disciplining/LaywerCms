package com.hyg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 页面控制器
 */
@Controller
public class PageController
{

	/**
	 * 将 views 目录称为 第1层 目录
	 * 那么 home、user 等就是 第2层 目录
	 * 这个方法用来获得 第2层目录下的html文件
	 *
	 * 请求地址为：/getPage/第2层目录名/文件名
	 *
	 * 文件名不带扩展名
	 * @param secondDir
	 * @param page
	 * @return
	 */
	@GetMapping("/getPage/{secondDir}/{page}")
	public String getPage
	(
		@PathVariable("secondDir") String secondDir,
		@PathVariable("page") String page
	)
	{
		return secondDir + "/" + page;
	}
}