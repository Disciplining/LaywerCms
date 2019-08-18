package com.hyg.service;

import com.hyg.pojo.Case;
import com.hyg.util.respond.CaseLinkageData;
import com.hyg.util.respond.RespondJson;

/**
 * 案例表
 */
public interface CaseService
{
	/**
	 * 获得添加案例时的联运数据
	 * @return
	 */
	RespondJson<CaseLinkageData> getLinkageDate();

	/**
	 * 添加一个案例
	 * 前端传过来的数据：
	 * chargeName 罪名名称
	 *
	 * title      案例标题
	 * desc       案例介绍
	 * process    办案过程
	 * @param onCase
	 * @return
	 */
	boolean insertOneCase(Case onCase, String chargeName);
}