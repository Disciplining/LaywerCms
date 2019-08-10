package com.hyg.controller;

import com.hyg.pojo.ArticleExpand;
import com.hyg.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 向表中插入数据
 */
@Controller
@RequestMapping("/insertData")
public class InsertController
{
	@Autowired
	@Qualifier("insertServiceImpl")
	private InsertService insertService;

	/**
	 * 团队文集表
	 * @param articleExpand
	 * @param model
	 * @return
	 */
	@PostMapping("/Article")
	public String insertArticle(ArticleExpand articleExpand, Model model)
	{
		boolean insertFlag = insertService.insertTableArticle(articleExpand);

		if (insertFlag)
		{
			return "base/collectionMgr";
		}
		else
		{
			model.addAttribute("res", "插入数据失败");
			return "base/collectionAdd";
		}
	}
}