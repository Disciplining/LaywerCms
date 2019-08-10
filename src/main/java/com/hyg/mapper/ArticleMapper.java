package com.hyg.mapper;

import com.hyg.pojo.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service("articleMapper")
public interface ArticleMapper
{
	/**
	 * 团队文集表
	 * @return
	 */
	@Select("select * from `t_article`")
	List<Article> listArticles();

	/**
	 * 后期改成逻辑删除
	 * 根据id删除一个团队文集
	 * @param articleId
	 */
	@Delete("delete from `t_article` where `articleId`=#{articleId}")
	boolean deleteOneArticleById(int articleId);

	/**
	 * 向团队文集表中新增一条数据
	 * @param article
	 */
	@Insert("insert into `t_article` (`type`,`articleTitle`,`author`,`intro`,`content`,`editDate`,`count`,`deleteFlag`)" +
				"values (#{type},#{articleTitle},#{author},#{intro},#{content},#{editDate},#{count},#{deleteFlag})")
	void insertOneArticle(Article article);

	/**
	 * 根据id更新团队文集表中的一条数据
	 * count 与 deleteFlag 更新
	 * @param article
	 */
	@Update("update `t_article` set `articleId`=#{articleId},`type`=#{type},`articleTitle`=#{articleTitle},`author`=#{author},`intro`=#{intro},`content`=#{content},`editDate`=#{editDate}" +
				"where `articleId`=#{articleId}")
	void updateOneArticleById(Article article);
}