package com.hyg.service;

import com.hyg.pojo.ChargeType;
import com.hyg.util.RespondJson;

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
	 * 罪名分类表 分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	RespondJson<ChargeType> charTypePageData(int pageNum, int pageSize);
}