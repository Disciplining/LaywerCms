package com.hyg.service;

import com.hyg.pojo.ArticleExpand;
import com.hyg.util.RespondJson;

public interface ArticleService
{
	/**
	 * 编辑团队文集
	 * @param articleExpand 用户传过来的数据
	 * @return
	 */
	boolean editOneArticle(ArticleExpand articleExpand);

	/**
	 * 新增一条团队文集数据
	 * @param articleExpand
	 * @return
	 */
	boolean insertOneArticle(ArticleExpand articleExpand);

	/**
	 * 根据id
	 * 删除团队文集表中的一条数据
	 * @param id
	 */
	boolean deleteOneArticleById(int id);

	/**
	 * 分页数据
	 * @param author
	 * @return
	 */
	RespondJson<ArticleExpand> listPageData(int pageNum, int pageSize, String author, String typeExpand);

	/**
	 * 根据id获得一篇文章
	 * @param id
	 * @return
	 */
	RespondJson<ArticleExpand> getOneArticleById(int id);
}