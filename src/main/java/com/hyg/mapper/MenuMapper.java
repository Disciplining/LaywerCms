package com.hyg.mapper;

import com.hyg.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("menuMapper")
public interface MenuMapper
{
	/**
	 * 获得菜单表中的所数据的所有信息
	 * @return
	 */
	@Select("select * from `t_menu`")
	List<Menu> listMenus();
}