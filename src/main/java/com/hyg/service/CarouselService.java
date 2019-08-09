package com.hyg.service;

import com.hyg.pojo.Carousel;
import com.hyg.util.RespondJson;

public interface CarouselService
{
	/**
	 * 获得轮播图json数据 对应的对象
	 * @return
	 */
	RespondJson<Carousel> getCarouselData();
}