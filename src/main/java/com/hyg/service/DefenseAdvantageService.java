package com.hyg.service;

import com.hyg.pojo.DefenseAdvantageExpand;

public interface DefenseAdvantageService
{
	/**
	 * 添加一条数据
	 * @param advantage
	 * @return
	 */
	boolean insertOneAdvantage(DefenseAdvantageExpand advantage);
}