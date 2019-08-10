package com.hyg.controller;

import com.hyg.pojo.ArticleExpand;
import com.hyg.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 更新表中的数据
 */
@Controller
@RequestMapping("/updateData")
public class UpdateController
{
	@Autowired
	@Qualifier("updateServiceImpl")
	private UpdateService updateService;

	@PostMapping("/Article")
	public String updateArticle(ArticleExpand articleExpand, Model model)
	{
		boolean success = updateService.updateTableArticle(articleExpand);

		if (success)
		{
			return "base/collectionMgr";
		}
		else
		{
			model.addAttribute("res", "更新数据失败");
			return "base/editCollection";
		}
	}
}