package com.hyg.service;

import com.hyg.pojo.ArticleExpand;

/**
 * 向数据库中的表插入数据
 * 除了自增字段 全部插入
 */
public interface InsertTableDataService
{
	/**
	 * 团队文集表
	 * @param articleExpand
	 * @return
	 */
	public boolean insertTableArticle(ArticleExpand articleExpand);
}