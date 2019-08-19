package com.hyg.mapper;

import com.hyg.pojo.DefenseDesc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 刑辨介绍表
 */
@Mapper
@Repository("defenseDescMapper")
public interface DefenseDescMapper
{
	/**
	 * 获得刑辨介绍表中的数据  只有一条数据
	 * @return
	 */
	@Select(" select * from `t_defenseDesc` where `deleteFlag`!='1' ")
	List<DefenseDesc> listDefenseDesc();

	/**
	 * 更新刑辨介绍
	 * 更新的数据：desc、editDate
	 * @param defenseDesc
	 */
	@Update(" update `t_defenseDesc` set `desc`=#{desc},`editDate`=#{editDate} where `deleteFlag`!='1' ")
	void updateDesc(DefenseDesc defenseDesc);
}