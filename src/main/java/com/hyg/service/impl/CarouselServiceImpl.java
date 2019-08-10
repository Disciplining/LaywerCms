package com.hyg.service.impl;

import com.hyg.mapper.CarouselMapper;
import com.hyg.pojo.Carousel;
import com.hyg.service.CarouselService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carouselServiceImpl")
public class CarouselServiceImpl implements CarouselService
{
	@Autowired
	@Qualifier("carouselMapper")
	private CarouselMapper carouselMapper;

	/**
	 * 获得符合前端格式的
	 * 轮播图表的数据
	 *
	 * @return
	 */
	@Override
	public RespondJson<Carousel> getCarouselData()
	{
		List<Carousel> list = carouselMapper.listCarousels();

		RespondJson<Carousel> json = new RespondJson<>();
		json.setCode(0);
		json.setMsg(null);
		json.setCount(list.size());
		json.setData(list);

		return json;
	}
}