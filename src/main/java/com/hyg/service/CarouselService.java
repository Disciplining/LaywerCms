package com.hyg.service;

import com.hyg.pojo.Carousel;
import com.hyg.util.RespondJson;

public interface CarouselService
{
	/**
	 * 获得符合前端格式的
	 * 轮播图表的数据
	 * @return
	 */
	RespondJson<Carousel> getCarouselData();
}
