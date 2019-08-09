package com.hyg.controller;

import com.hyg.pojo.Carousel;
import com.hyg.service.CarouselService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 轮播图控制器
 */
@Controller
public class CarouselController
{
	@Autowired
	@Qualifier("carouselServiceImpl")
	private CarouselService carouselService;

	/**
	 * 返回前端需要的轮播图json数据
	 * @return
	 */
	@GetMapping("/getCarouselData")
	@ResponseBody
	public RespondJson<Carousel> getCarouselData()
	{
		return carouselService.getCarouselData();
	}
}