package com.hyg.mapper;

import com.hyg.pojo.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
@Service("articleMapper")
public interface ArticleMapper
{
	/**
	 * 获取未被删除的文章总数
	 * @return
	 */
	@Select(" select count(*) from `t_article` where `deleteFlag`!='1' ")
	int countArticleSum();

	/**
	 * 根据id删除一个团队文集
	 * @param articleId
	 */
	@Update(" update `t_article` set `deleteFlag`='1' where `articleId`=#{articleId} ")
	boolean deleteOneArticleById(int articleId);

	/**
	 * 向团队文集表中新增一条数据
	 * @param article
	 */
	@Insert("insert into `t_article` (`type`,`articleTitle`,`author`,`intro`,`content`,`editDate`,`count`,`deleteFlag`)" +
				"values (#{type},#{articleTitle},#{author},#{intro},#{content},#{editDate},#{count},#{deleteFlag})")
	void insertOneArticle(Article article);

	/**
	 * 编辑文集调用这个语句
	 * 根据id更新团队文集表中的一条数据
	 * count 与 deleteFlag 更新
	 * @param article
	 */
	@Update("update `t_article` set `articleId`=#{articleId},`type`=#{type},`articleTitle`=#{articleTitle},`author`=#{author},`intro`=#{intro},`content`=#{content},`editDate`=#{editDate}" +
				"where `articleId`=#{articleId}")
	void updateOneArticleById(Article article);

	/**
	 * 根据文章作者和文章类型查找文章
	 * @param par
	 * @return
	 */
	@Select(" select * from `t_article` " +
				" where `deleteFlag`!='1' and " +
					" ( `author` like concat('%',#{author},'%') and `type` like concat('%',#{type},'%') )")
	List<Article> listArticlesByAuthor(Map<String, Object> par);
}