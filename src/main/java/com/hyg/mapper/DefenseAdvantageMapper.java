package com.hyg.mapper;

import com.hyg.pojo.DefenseAdvantage;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("defenseAdvantageMapper")
public interface DefenseAdvantageMapper
{
	/**
	 * 添加一条数据
	 * @param advantage
	 */
	@Insert(" insert into `t_defenseAdvantage` (`title`,`content`,`icon`,`editDate`,`count`,`deleteFlag`) " +
				" values (#{title},#{content},#{icon},#{editDate},#{count},#{deleteFlag}) ")
	void insertOneAdvantage(DefenseAdvantage advantage);

	/**
	 * 获得所有的数据
	 * @return
	 */
	@Select(" select * from `t_defenseAdvantage` where `deleteFlag`!='1' ")
	List<DefenseAdvantage> listAllDefenseAdvantage();

	/**
	 * 根据id获得一条数据
	 * @param id
	 * @return
	 */
	@Select(" select * from `t_defenseAdvantage` where `deleteFlag`!='1' and `id`=#{id} ")
	DefenseAdvantage getOneDefenseAdvantageById(int id);

	/**
	 * 根据id删除一条数据
	 * @param id
	 */
	@Delete(" update `t_defenseAdvantage` set `deleteFlag`='1' where `id`=#{id} ")
	void deleteOneDefenseAdvantageById(int id);

	/**
	 * 更新一条数据
	 * 更新的字段：title、content、icon、editDate
	 * @param advantage
	 */
	@Update(" update `t_defenseAdvantage` set `title`=#{title},`content`=#{content},`icon`=#{icon},`editDate`=#{editDate} " +
				" where `id`=#{id} ")
	void updateEditOneDefenseAdvantage(DefenseAdvantage advantage);
}