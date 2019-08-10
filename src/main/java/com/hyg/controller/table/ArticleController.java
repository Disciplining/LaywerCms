package com.hyg.controller.table;

import com.hyg.pojo.ArticleExpand;
import com.hyg.service.DeleteService;
import com.hyg.service.InsertService;
import com.hyg.service.SelectService;
import com.hyg.service.UpdateService;
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
	@Qualifier("deleteServiceImpl")
	private DeleteService deleteService;

	@Autowired
	@Qualifier("insertServiceImpl")
	private InsertService insertService;

	@Autowired
	@Qualifier("selectServiceImpl")
	private SelectService selectService;

	@Autowired
	@Qualifier("updateServiceImpl")
	private UpdateService updateService;


	/**
	 * 获得团队文集表中的所有数据
	 * @return
	 */
	@GetMapping("/getArticleData")
	@ResponseBody
	public RespondJson<ArticleExpand> getArticleData()
	{
		return selectService.getArticleData();
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
		if (deleteService.deleteOneArticleById(Integer.parseInt(id)))
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

	/**
	 * 编辑团队文集
	 * @param articleExpand
	 * @param model
	 * @return
	 */
	@PostMapping("/updateData/article")
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