package com.hyg.mapper;

import com.hyg.pojo.Article;
import com.hyg.pojo.Carousel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 这里边的SQL语句
 * 都是用来给表插入数据的
 * 每次只插入一条数据
 * 且插入时 除了自增的字段都要写
 */
@Mapper
@Repository("insertMapper")
public interface InsertMapper
{
	/**
	 * 团队文集表
	 * @param article
	 */
	@Insert("insert into `t_article` (`type`,`articleTitle`,`author`,`intro`,`content`,`editDate`,`count`,`deleteFlag`)" +
				"values (#{type},#{articleTitle},#{author},#{intro},#{content},#{editDate},#{count},#{deleteFlag})")
	void insertOneArticle(Article article);

	/**
	 * 轮播图表
	 * @param carousel
	 */
	@Insert("insert into `t_carousel` (`id`,`bannerName`,`imgPath`,`editDate`) values(#{id},#{bannerName},#{imgPath},#{editDate})")
	void insertOneCarousel(Carousel carousel);
}