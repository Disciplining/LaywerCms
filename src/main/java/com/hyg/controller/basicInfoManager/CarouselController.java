package com.hyg.controller.basicInfoManager;

import com.hyg.pojo.Carousel;
import com.hyg.pojo.CarouselExpand;
import com.hyg.service.CarouselService;
import com.hyg.shiro.PermissionPrefix;
import com.hyg.util.respond.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/getCarouselData")
	@ResponseBody
	public RespondJson<Carousel> getCarouselData()
	{
		return carouselService.getCarouselData();
	}

	/**
	 * 添加一个轮播图
	 * @param carouselExpand
	 * @param model
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.INSERT_DATA + "/insertOneCarousel")
	public String insertOneCarousel(CarouselExpand carouselExpand, Model model)
	{
		if (carouselService.insertOneCarousel(carouselExpand))
		{
			return "base/bannerMgr";
		}
		else
		{
			model.addAttribute("res", "添加轮播图失败");
			return "base/upload";
		}
	}

	/**
	 * 根据id删除一个轮播图
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.DELETE_DATA + "/deleteOneCarouseById")
	@ResponseBody
	public String deleteOneCarouseById(@RequestParam(name = "id") int id)
	{
		if (carouselService.deleteOneCarouseById(id))
		{
			return "success";
		}
		else
		{
			return "fail";
		}
	}
}