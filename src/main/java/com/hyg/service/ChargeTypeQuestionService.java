package com.hyg.service;

import com.hyg.pojo.ChargeTypeQuestion;
import com.hyg.util.RespondJson;

public interface ChargeTypeQuestionService
{
	/**
	 * 插入一条问答数据
	 * 前端传过来的数据：chargeTypeName  question、answer
	 * @param question
	 * @return
	 */
	boolean insertOneChargeTypeQuestion(ChargeTypeQuestion question, String chargeTypeName);

	/**
	 * 分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	RespondJson<ChargeTypeQuestion> pageData(int pageNum, int pageSize);
}