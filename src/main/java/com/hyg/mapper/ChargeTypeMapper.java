package com.hyg.mapper;

import com.hyg.pojo.ChargeType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 罪名分类表 mapper
 */
@Mapper
@Repository("chargeTypeMapper")
public interface ChargeTypeMapper
{
	/**
	 * 添加一个 罪名分类
	 * @param chargeType
	 */
	@Insert(" insert into `t_chargeType` (`chargeTypeName`,`editDate`,`count`,`deleteFlag`) " +
				" values (#{chargeTypeName},#{editDate},#{count},#{deleteFlag}) ")
	void insertOneChargeType(ChargeType chargeType);
}