package com.hyg.mapper;

import com.hyg.pojo.Charge;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
	 * 根据罪名名称获搜索
	 * @param chargeName
	 * @return
	 */
	@Select(" select * from `t_charge` where `chargeName` like concat('%',#{chargeName},'%') ")
	List<Charge> listChargeByChargeName(String chargeName);
}