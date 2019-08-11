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
	 * 获得前端需要的格式的
	 * 团队文集表的所有数据
	 * @return
	 */
	RespondJson<ArticleExpand> getArticleData();

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
	 * 根据作者查找文集
	 * @param author
	 * @return
	 */
	RespondJson<ArticleExpand> listArticlesByAuthor(String author);
}