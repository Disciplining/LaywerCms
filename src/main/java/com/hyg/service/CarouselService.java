package com.hyg.service;

import com.hyg.pojo.Carousel;
import com.hyg.pojo.CarouselExpand;
import com.hyg.util.RespondJson;

public interface CarouselService
{
	/**
	 * 获得符合前端格式的
	 * 轮播图表的数据
	 * @return
	 */
	RespondJson<Carousel> getCarouselData();

	/**
	 * 向轮播图表中插入一条数据
	 * 前端传过来的数据：轮播图名称、图片文件
	 * @param carouselExpand
	 * @return
	 */
	boolean insertOneCarousel(CarouselExpand carouselExpand);

	/**
	 * 根据id删除一个轮播图
	 * @param id
	 * @return
	 */
	boolean deleteOneCarouseById(int id);
}
