package com.hyg.controller;

import com.hyg.pojo.ArticleExpand;
import com.hyg.service.ArticleService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController
{
	@Autowired
	@Qualifier("articleServiceImpl")
	private ArticleService articleService;

	/**
	 * 返回前端需要的团队文集 json数据
	 * @return
	 */
	@GetMapping("/getArticleData")
	@ResponseBody
	public RespondJson<ArticleExpand> getCarouselData()
	{
		return articleService.getCarouselData();
	}
}