package com.hyg.controller;

import com.hyg.pojo.ArticleExpand;
import com.hyg.service.InsertTableDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 向表中插入数据
 */
@Controller
@RequestMapping("/insertData")
public class InsertTableController
{
	@Autowired
	@Qualifier("insertTableDataServiceImpl")
	private InsertTableDataService insertTableDataService;

	@PostMapping("/Article")
	@ResponseBody
	public Map<String, String> insertArticle(ArticleExpand articleExpand)
	{
		insertTableDataService.insertTableArticle(articleExpand);

		Map<String, String> map = new HashMap<>();

		map.put("a", "bb");

		return map;
	}
}