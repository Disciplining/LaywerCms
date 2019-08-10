package com.hyg.mapper;

import com.hyg.pojo.Carousel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service("carouselMapper")
public interface CarouselMapper
{
	/**
	 * 轮播图表
	 * @return
	 */
	@Select("select * from `t_carousel`")
	List<Carousel> listCarousels();

	/**
	 * 向轮播图表中插入一条数据
	 * @param carousel
	 */
	@Insert("insert into `t_carousel` (`bannerName`,`imgPath`,`editDate`) values(#{bannerName},#{imgPath},#{editDate})")
	void insertOneCarousel(Carousel carousel);
}