package com.hyg.mapper;

import com.hyg.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 根据主键
 * 更新表的SQL语句
 * 除了自增字段 都更新
 */
@Mapper
@Repository("updateMapper")
public interface UpdateMapper
{
	/**
	 * 团队文集表
	 * count 与 deleteFlag不形影相随
	 * @param article
	 */
	@Update("update `t_article` set `articleId`=#{articleId},`type`=#{type},`articleTitle`=#{articleTitle},`author`=#{author},`intro`=#{intro},`content`=#{content},`editDate`=#{editDate}" +
				"where `articleId`=#{articleId}")
	void updateArticle(Article article);
}