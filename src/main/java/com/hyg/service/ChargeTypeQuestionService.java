package com.hyg.service;

import com.hyg.pojo.ChargeTypeQuestion;

public interface ChargeTypeQuestionService
{
	/**
	 * 插入一条问答数据
	 * 前端传过来的数据：chargeTypeName  question、answer
	 * @param question
	 * @return
	 */
	boolean insertOneChargeTypeQuestion(ChargeTypeQuestion question, String chargeTypeName);
}