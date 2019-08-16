package com.hyg.service;

import com.hyg.pojo.ChargeType;

import java.util.List;

/**
 * 罪名分类表 service
 */
public interface ChargeTypeService
{
	/**
	 * 添加一个罪名分类
	 * 前端传来的数据：chargeTypeName
	 * 需要添加的数据：chargeTypeName、editDate、count、deleteFlag
	 * @param chargeType
	 * @return
	 */
	boolean insertOneChargeType(ChargeType chargeType);

	/**
	 * 获得所有
	 * @return
	 */
	List<ChargeType> listAllChargeType();
}