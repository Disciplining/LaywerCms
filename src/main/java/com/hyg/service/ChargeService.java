package com.hyg.service;

import com.hyg.pojo.Charge;
import com.hyg.pojo.extend.ChargeExtend;
import com.hyg.util.respond.RespondJson;

public interface ChargeService
{
	/**
	 * 添加一个罪名
	 * 前端传过来的数据：chargeTypeName、chargeName、lawContent、sentenceRange、defense
	 * @param charge
	 * @return
	 */
	boolean insertOneCharge(Charge charge, String chargeTypeName);

	/**
	 * 罪名表分页数据
	 * @param pageNum
	 * @param pageSize
	 * @param chargeName
	 * @return
	 */
	RespondJson<ChargeExtend> chargePageData(int pageNum, int pageSize, String chargeName);

	/**
	 * 根据id删除一个罪名
	 * @param id
	 * @return
	 */
	boolean deleteOneChargeById(int id);

	/**
	 * 根据id获取一个罪名
	 * @param id
	 * @return
	 */
	RespondJson<Charge> getOneChargeById(int id);

	/**
	 * 根据id编辑一个罪名
	 * @param charge
	 * @return
	 */
	boolean updateEditChargeById(Charge charge);
}