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

	/**
	 * 根据id删除一个问答
	 * @param id
	 * @return
	 */
	boolean deleteOneQuestionById(int id);

	/**
	 * 根据id获得一条数据
	 * @param id
	 * @return
	 */
	RespondJson<ChargeTypeQuestion> getOneQuestionById(int id);
}