package com.hyg.mapper;

import com.hyg.pojo.ChargeType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 罪名分类表 mapper
 */
@Mapper
@Repository("chargeTypeMapper")
public interface ChargeTypeMapper
{
	/*查*/
	/**
	 * 根据id获得一个罪名分类
	 * @param id
	 * @return
	 */
	@Select(" select * from `t_chargeType` where `id`=#{id} ")
	ChargeType getOneChargeTypeById(int id);

	/**
	 * 根据 罪名分类名称 获得 一个罪名分类
	 * @param name
	 * @return
	 */
	@Select(" select * from `t_chargeType` where `chargeTypeName`=#{name} ")
	ChargeType getOneChargeTypeByName(String name);

	/**
	 * 获得所有罪名分类
	 * @return
	 */
	@Select(" select * from `t_chargeType` ")
	List<ChargeType> listAllChargeType();

	/**
	 * 获得所有罪名分类的名称
	 * @return
	 */
	@Select(" select `chargeTypeName` from `t_chargeType` ")
	List<String> listChargeTypeName();

	/**
	 * 根据id获得一个罪名分类的名称
	 * @param id
	 * @return
	 */
	@Select(" select `chargeTypeName` from `t_chargeType` where `id`=#{id} ")
	String getOneChargetypenameById(int id);
	/*---------------------------------------------------------------------------------------------------*/

	/*增*/
	/**
	 * 添加一个 罪名分类
	 * @param chargeType
	 */
	@Insert(" insert into `t_chargeType` (`chargeTypeName`,`editDate`,`count`,`deleteFlag`) " +
				" values (#{chargeTypeName},#{editDate},#{count},#{deleteFlag}) ")
	void insertOneChargeType(ChargeType chargeType);
	/*---------------------------------------------------------------------------------------------------*/

	/*改*/
	/**
	 * 根据id更新罪名分类名称
	 * @param chargeType
	 */
	@Update(" update `t_chargeType` set `chargeTypeName`=#{chargeTypeName} where `id`=#{id} ")
	void updateChargeTypeNameById(ChargeType chargeType);
	/*---------------------------------------------------------------------------------------------------*/

	/*删*/
	/**
	 * 根据id删除一条数据
	 * @param id
	 */
	@Delete(" delete from `t_chargeType` where `id`=#{id} ")
	void deleteOneChargeType(int id);
	/*---------------------------------------------------------------------------------------------------*/
}