package com.hyg.service.impl;

import com.hyg.config.PicDir;
import com.hyg.mapper.CarouselMapper;
import com.hyg.pojo.Carousel;
import com.hyg.pojo.CarouselExpand;
import com.hyg.service.CarouselService;
import com.hyg.util.FileUtil;
import com.hyg.util.respond.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
		Carousel carousel = new Carousel(); // 组装这个对象

		// 前端传过来的数据
		carousel.setBannerName(carouselExpand.getBannerName());
		String allPicDir = picDirSetting.substring(picDirSetting.indexOf(':')+1); //存储图片的总目录
		String bannerPicDir = allPicDir + PicDir.BANNER_DIR; // 存储轮播图图片的目录
		String picUrl = FileUtil.savePicToDisk(carouselExpand.getFile(), bannerPicDir, PicDir.BANNER_DIR);
		if (picUrl != null)
		{
			carousel.setImgPath(picUrl);
		}

		// 其他没有传过来的数据
		carousel.setEditDate(new Timestamp(System.currentTimeMillis()));

		System.out.println("日期++++++++++++++ " +carousel);

		try
		{
			carouselMapper.insertOneCarousel(carousel);
		}
		catch (Exception e)
		{
			System.out.println("++++++++++出现了异常+++++++++++++");
			return false;
		}

		return true;
	}

	/**
	 * 根据id删除一个轮播图
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteOneCarouseById(int id)
	{
		try
		{
			carouselMapper.deleteOneCarouseById(id);
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
}