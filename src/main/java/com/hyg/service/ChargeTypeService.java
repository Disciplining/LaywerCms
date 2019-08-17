package com.hyg.service;

import com.hyg.pojo.ChargeType;
import com.hyg.util.RespondJson;

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
	 * 罪名分类表 分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	RespondJson<ChargeType> charTypePageData(int pageNum, int pageSize);

	/**
	 * 根据id获得一个罪名分类
	 * @param id
	 * @return
	 */
	RespondJson<ChargeType> getOneChargeTypeById(int id);

	/**
	 * 编辑一个罪名类型
	 * 前端需要传过来的数据：id、chargeTypeName
	 * 需要更新的数据：chargeTypeName
	 * @param chargeType
	 * @return
	 */
	boolean editChargeType(ChargeType chargeType);

	/**
	 * 根据id删除一个罪名分类
	 * @param id
	 * @return
	 */
	boolean deleteOneChargeType(int id);

	/**
	 * 获得所有罪名分类
	 * @return
	 */
	List<String> listChargeTypeName();
}