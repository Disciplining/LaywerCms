package com.hyg.service;

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
}