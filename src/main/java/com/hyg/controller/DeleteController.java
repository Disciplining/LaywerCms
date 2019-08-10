package com.hyg.controller;

import com.hyg.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 根据主键删除表中的数据
 */
@Controller
@RequestMapping("/deleteData")
public class DeleteController
{
	@Autowired
	@Qualifier("deleteServiceImpl")
	private DeleteService deleteService;

	@GetMapping("/article")
	String deleteOneArticleById(@RequestParam("id") String id)
	{
		deleteService.deleteOneArticleById(Integer.parseInt(id));

		return "base/collectionMgr";
	}
}