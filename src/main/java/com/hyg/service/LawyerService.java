package com.hyg.service;

import com.hyg.util.JsonRep;
import com.hyg.util.LawyerRep;

public interface LawyerService
{
	/**
	 * 获得律师信息
	 * @return
	 */
	JsonRep<LawyerRep> getLawyerData();
}