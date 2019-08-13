package com.hyg.service.impl;

import com.hyg.mapper.CarouselMapper;
import com.hyg.pojo.Carousel;
import com.hyg.pojo.CarouselExpand;
import com.hyg.service.CarouselService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carouselServiceImpl")
public class CarouselServiceImpl implements CarouselService
{
	@Autowired
	@Qualifier("carouselMapper")
	private CarouselMapper carouselMapper;

	@Value("${cbs.imagesPath}")
	private String picDirSetting; //全局配置文件中设置的图片的路径

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

	/**
	 * 向轮播图表中插入一条数据
	 * 前端传过来的数据：轮播图名称、图片文件
	 *
	 * @param carouselExpand
	 * @return
	 */
	@Override
	public boolean insertOneCarousel(CarouselExpand carouselExpand)
	{
		Carousel carousel = new Carousel();
		carousel.setBannerName(carouselExpand.getBannerName());

		String allPicDir = picDirSetting.substring(picDirSetting.indexOf(':')+1); //存储图片的总目录

		return false;
	}
}