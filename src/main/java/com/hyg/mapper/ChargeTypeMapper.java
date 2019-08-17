package com.hyg.mapper;

import com.hyg.pojo.ChargeType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 罪名分类表 mapper
 */
@Mapper
@Repository("chargeTypeMapper")
public interface ChargeTypeMapper
{
	/**
	 * 根据id获得一个罪名分类
	 * @param id
	 * @return
	 */
	@Select(" select * from `t_chargeType` where `deleteFlag`!='1' and `id`=#{id} ")
	ChargeType getOneChargeTypeById(int id);

	/**
	 * 根据罪名分类名称获得一个罪名分类
	 * @param name
	 * @return
	 */
	@Select(" select * from `t_chargeType` where `deleteFlag`!='1' and `chargeTypeName`=#{name} ")
	ChargeType getOneChargeTypeByName(String name);


	/**
	 * 添加一个 罪名分类
	 * @param chargeType
	 */
	@Insert(" insert into `t_chargeType` (`chargeTypeName`,`editDate`,`count`,`deleteFlag`) " +
				" values (#{chargeTypeName},#{editDate},#{count},#{deleteFlag}) ")
	void insertOneChargeType(ChargeType chargeType);

	/**
	 * 获得所有罪名
	 * @return
	 */
	@Select(" select * from `t_chargeType` where `deleteFlag`!='1' ")
	List<ChargeType> listAllChargeType();

	/**
	 * 根据id更新罪名分类名称
	 * @param chargeType
	 */
	@Update(" update `t_chargeType` set `chargeTypeName`=#{chargeTypeName} where `deleteFlag`!='1' and `id`=#{id} ")
	void updateChargeTypeNameById(ChargeType chargeType);

	@Update(" update `t_chargeType` set `deleteFlag`='1' where `id`=#{id} ")
	void deleteOneChargeType(int id);

	/**
	 * 获得所有罪名分类
	 * @return
	 */
	@Select(" select `chargeTypeName` from `t_chargeType` where `deleteFlag`!='1' ")
	List<String> listChargeTypeName();
}