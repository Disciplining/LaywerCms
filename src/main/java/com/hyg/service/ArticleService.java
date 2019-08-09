package com.hyg.service;

import com.hyg.pojo.ArticleExpand;
import com.hyg.util.RespondJson;

public interface ArticleService
{
	/**
	 * 获得团队文集 json数据 对应的对象
	 * @return
	 */
	RespondJson<ArticleExpand> getCarouselData();
}