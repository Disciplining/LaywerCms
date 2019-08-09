package com.hyg.controller;

import com.hyg.pojo.*;
import com.hyg.service.GetTableService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 返回数据库表中的所有数据
 * json数据
 */
@Controller
public class GetDataController
{
	@Autowired
	@Qualifier("getTableServiceImpl")
	private GetTableService getTableService;

	/*============================================================*/

	/**
	 * 团队文集表
	 * @return
	 */
	@GetMapping("/getArticleData")
	@ResponseBody
	public RespondJson<ArticleExpand> getArticleData()
	{
		return getTableService.getArticleData();
	}

	/**
	 * 轮播图表
	 * @return
	 */
	@GetMapping("/getCarouselData")
	@ResponseBody
	public RespondJson<Carousel> getCarouselData()
	{
		return getTableService.getCarouselData();
	}

	/**
	 * 留言表
	 * @return
	 */
	@GetMapping("/getMsgBoardData")
	@ResponseBody
	public RespondJson<MsgBoard> getMsgBoardData()
	{
		return getTableService.getMsgBoardData();
	}

	/**
	 * 用户表
	 * @return
	 */
	@GetMapping("/getUserData")
	@ResponseBody
	public RespondJson<User> getUserData()
	{
		return getTableService.getUserData();
	}

	/**
	 * 事务所表，只有一条数据
	 * @return
	 */
	@GetMapping("/getAgencyData")
	@ResponseBody
	public RespondJson<Agency> getAgencyData()
	{
		return getTableService.getAgencyData();
	}
}