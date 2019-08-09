package com.hyg.mapper;

import com.hyg.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("articleMapper")
public interface ArticleMapper
{
	/**
	 * 获得团队文集的所有数据
	 * @return
	 */
	@Select("select * from `t_article`")
	List<Article> listArticles();

	/**
	 * 获得团队文集表的数据条数
	 * @return
	 */
	@Select("select count(*) from `t_carousel`")
	long countCarousel();
}