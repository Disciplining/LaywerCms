package com.hyg.service;

import com.hyg.pojo.Agency;
import com.hyg.util.respond.RespondJson;

public interface AgencyService
{
	/**
	 * 事务所表，只有一条数据
	 * @return
	 */
	RespondJson<Agency> getAgencyData();

	/**
	 * 修改事务所介绍
	 * @param detail
	 * @return
	 */
	boolean updateAgencyDetail(String detail);
}