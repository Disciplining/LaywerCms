package com.hyg.service;

import com.hyg.pojo.ArticleExpand;

public interface UpdateService
{
	/**
	 * 团队文集表
	 * @param articleExpand 用户传过来的数据
	 * @return
	 */
	boolean updateTableArticle(ArticleExpand articleExpand);
}