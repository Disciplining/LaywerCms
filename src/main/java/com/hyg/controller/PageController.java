package com.hyg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		@PathVariable("page") String page,
		@RequestParam(value = "id", defaultValue = "-1") String id,
		Model model
	)
	{
		if (!"-1".equals(id))
		{
			model.addAttribute("id", id);
		}

		return secondDir + "/" + page;
	}

	/**
	 * 获得 第3层 目录下的html文件
	 *
	 * 请求地址为：/getPage/第2层目录名/第3层目录名/文件名
	 *
	 * @param secondDir
	 * @param thirdDir
	 * @param page
	 * @return
	 */
	@GetMapping("/getPage/{secondDir}/{thirdDir}/{page}")
	public String getPate
	(
		@PathVariable("secondDir") String secondDir,
		@PathVariable("thirdDir") String thirdDir,
		@PathVariable("page") String page
	)
	{
		return secondDir + "/" + thirdDir + "/" + page;
	}

	/**
	 * 授权失败时访问的请求
	 * @return
	 */
	@GetMapping("/noPermission")
	@ResponseBody
	public String noPermission()
	{
		return "你没有权限访问这个页面";
	}
}