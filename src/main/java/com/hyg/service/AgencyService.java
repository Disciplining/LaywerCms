package com.hyg.service;

import com.hyg.pojo.Agency;
import com.hyg.util.RespondJson;

public interface AgencyService
{
	/**
	 * 事务所表，只有一条数据
	 * @return
	 */
	RespondJson<Agency> getAgencyData();
}