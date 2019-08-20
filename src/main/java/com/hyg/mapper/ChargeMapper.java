package com.hyg.mapper;

import com.hyg.pojo.Charge;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 罪名表 mapper
 */
@Mapper
@Repository("chargeMapper")
public interface ChargeMapper
{
	/**
	 * 添加一个罪名
	 * @param charge
	 */
	@Insert(" insert into `t_charge` (`chargeTypeId`,`chargeName`,`lawContent`,`sentenceRange`,`defense`,`editDate`,`count`,`deleteFlag`) " +
				" values (#{chargeTypeId},#{chargeName},#{lawContent},#{sentenceRange},#{defense},#{editDate},#{count},#{deleteFlag}) ")
	void insertOneCharge(Charge charge);

	/**
	 * 根据罪名名称 搜索
	 * @param chargeName
	 * @return
	 */
	@Select(" select * from `t_charge` where `chargeName` like concat('%',#{chargeName},'%') and `deleteFlag`!='1' ")
	List<Charge> listChargeByChargeName(String chargeName);

	/**
	 * 根据id删除一个罪名名称
	 * @param id
	 */
	@Update(" update `t_charge` set `deleteFlag`='1' where `id`=#{id} ")
	void deleteOneChargeById(int id);

	/**
	 * 根据id获取一条数据
	 * @param id
	 * @return
	 */
	@Select(" select * from `t_charge` where `id`=#{id} and `deleteFlag`!='1' ")
	Charge getOneChargeById(int id);

	/**
	 * 根据 罪名名称 获得一条数据
	 * @param chargeName
	 * @return
	 */
	@Select(" select * from `t_charge` where `chargeName`=#{chargeName} and `deleteFlag`!='1' ")
	Charge getOneChargeByChargeName(String chargeName);

	/**
	 * 根据id编辑一个罪名
	 * @param charge
	 */
	@Update(" update `t_charge` set `chargeName`=#{chargeName},`lawContent`=#{lawContent},`sentenceRange`=#{sentenceRange},`defense`=#{defense},`editDate`=#{editDate} " +
				" where `id`=#{id} ")
	void updateEditChargeById(Charge charge);

	/**
	 * 获得 某个罪名分类id 下的 所有罪名
	 * @return
	 */
	@Select(" select `chargeName` from `t_charge` where `chargeTypeId`=#{chargeTypeId} and `deleteFlag`!='1' ")
	List<String> listChargeNameByChargeTypeId(int chargeTypeId);

	/**
	 * 通过罪名名称获得罪名的id
	 * 罪名名称有唯一约束，所以只会查询到一个
	 * @param name
	 * @return
	 */
	@Select(" select `id` from `t_charge` " +
				" where `chargeName`='杀人' ")
	int getIdByChargeName(String name);
}