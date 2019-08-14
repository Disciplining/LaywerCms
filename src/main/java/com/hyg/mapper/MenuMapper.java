package com.hyg.mapper;

import com.hyg.pojo.Menu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service("menuMapper")
public interface MenuMapper
{
	/**
	 * 菜单表
	 * @return
	 */
	@Select("select * from `t_menu`")
	List<Menu> listMenus();

	/**
	 * 添加一个父级菜单
	 * @param menu
	 */
	@Insert(" insert into `t_menu` (`menuName`,`parentId`,`router`) values (#{menuName},#{parentId},#{router}) ")
	void insertOneFatherMenu(Menu menu);
}