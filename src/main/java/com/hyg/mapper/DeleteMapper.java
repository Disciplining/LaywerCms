package com.hyg.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 根据主键删除数据库中的数据
 */
@Mapper
@Repository("deleteMapper")
public interface DeleteMapper
{
	/**
	 * 团队文集表
	 * @param articleId
	 */
	@Delete("delete from `t_article` where `articleId`=#{articleId}")
	void deleteOneArticleById(int articleId);
}