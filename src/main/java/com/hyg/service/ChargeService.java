package com.hyg.service;

import com.hyg.pojo.Charge;
import com.hyg.util.RespondJson;

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
	RespondJson<Charge> chargePageData(int pageNum, int pageSize, String chargeName);
}