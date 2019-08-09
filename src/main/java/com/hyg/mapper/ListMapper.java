package com.hyg.mapper;

import com.hyg.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 这里边的SQL语句
 * 全部都是用来获取表中的数据
 * 且获取的是所有数据的所有字段
 */
@Mapper
@Repository("getDataMapper")
public interface ListMapper
{
	/**
	 * 事务所表  只有一条数据
	 * @return
	 */
	@Select("select * from `t_agency`")
	List<Agency> getAgency();

	/**
	 * 团队文集表
	 * @return
	 */
	@Select("select * from `t_article`")
	List<Article> listArticles();

	/**
	 * 轮播图表
	 * @return
	 */
	@Select("select * from `t_carousel`")
	List<Carousel> listCarousels();

	/**
	 * 菜单表
	 * @return
	 */
	@Select("select * from `t_menu`")
	List<Menu> listMenus();

	/**
	 * 留言表
	 * @return
	 */
	@Select("select * from `t_msgBoard`")
	List<MsgBoard> listMsgBoards();

	/**
	 * 用户表
	 * @return
	 */
	@Select("select * from `t_user`")
	List<User> listUsers();

	/**
	 * 律师表
	 * @return
	 */
	@Select("select * from `t_lawyer`")
	List<Lawyer> listLawyers();
}