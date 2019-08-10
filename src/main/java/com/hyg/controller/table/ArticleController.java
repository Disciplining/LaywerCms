package com.hyg.controller.table;

import com.hyg.pojo.ArticleExpand;
import com.hyg.service.ArticleService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController
{
	@Autowired
	@Qualifier("articleServiceImpl")
	private ArticleService articleService;


	/**
	 * 获得团队文集表中的所有数据
	 * @return
	 */
	@GetMapping("/getArticleData")
	@ResponseBody
	public RespondJson<ArticleExpand> getArticleData()
	{
		return articleService.getArticleData();
	}

	/**
	 * 根据id
	 * 从团队文集表中删除一条数据
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteData/article")
	@ResponseBody
	public String deleteOneArticleById(@RequestParam("id") String id)
	{
		if (articleService.deleteOneArticleById(Integer.parseInt(id)))
		{
			return "success";
		}
		else
		{
			return "fail";
		}
	}

	/**
	 * 新建团队文集
	 * @param articleExpand
	 * @param model
	 * @return
	 */
	@PostMapping("/insertData/article")
	public String insertArticle(ArticleExpand articleExpand, Model model)
	{
		boolean insertFlag = articleService.insertOneArticle(articleExpand);

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

	/**
	 * 编辑团队文集
	 * @param articleExpand
	 * @param model
	 * @return
	 */
	@PostMapping("/updateData/article")
	public String editOneArticle(ArticleExpand articleExpand, Model model)
	{
		boolean success = articleService.editOneArticle(articleExpand);

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