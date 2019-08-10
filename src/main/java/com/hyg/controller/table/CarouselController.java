package com.hyg.controller.table;

import com.hyg.pojo.Carousel;
import com.hyg.service.CarouselService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarouselController
{
	@Autowired
	@Qualifier("carouselServiceImpl")
	private CarouselService carouselService;

	/**
	 * 获得轮播图表中的所有数据
	 * @return
	 */
	@GetMapping("/selectData/getCarouselData")
	@ResponseBody
	public RespondJson<Carousel> getCarouselData()
	{
		return carouselService.getCarouselData();
	}
}