package com.hyg.mapper;

import com.hyg.pojo.DefenseAdvantage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
}