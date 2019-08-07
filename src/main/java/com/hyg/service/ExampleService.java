package com.hyg.service;

import com.hyg.util.ExampleRep;
import com.hyg.util.JsonRep;

public interface ExampleService
{
	/**
	 * 获取案例数据
	 * @return
	 */
	JsonRep<ExampleRep> getExampleData();
}
