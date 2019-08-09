package com.hyg.mapper;

import com.hyg.pojo.Carousel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("carouselMapper")
public interface CarouselMapper
{
	/**
	 * 获得所有轮播图的所有数据
	 * @return
	 */
	@Select("select * from `t_carousel`")
	List<Carousel> listCarousels();

	/**
	 * 获得轮播图的条数
	 * @return
	 */
	@Select("select count(*) from `t_carousel`")
	long countCarousel();
}