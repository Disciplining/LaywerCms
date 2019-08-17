package com.hyg.service.impl;

import com.hyg.mapper.ChargeTypeMapper;
import com.hyg.mapper.ChargeTypeQuestionMapper;
import com.hyg.pojo.ChargeTypeQuestion;
import com.hyg.service.ChargeTypeQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service("chargeTypeQuestionServiceImpl")
public class ChargeTypeQuestionServiceImpl implements ChargeTypeQuestionService
{
	@Autowired
	@Qualifier("chargeTypeQuestionMapper")
	private ChargeTypeQuestionMapper mapper;

	@Autowired
	@Qualifier("chargeTypeMapper")
	private ChargeTypeMapper chargeTypeMapper;

	/**
	 * 插入一条问答数据
	 * 前端传过来的数据：chargeTypeName  question、answer
	 *
	 * @param question
	 * @return
	 */
	@Override
	public boolean insertOneChargeTypeQuestion(ChargeTypeQuestion question, String chargeTypeName)
	{
		int chargeTypeId;
		try
		{
			chargeTypeId = chargeTypeMapper.getOneChargeTypeByName(chargeTypeName).getId();
		}
		catch (Exception e) // 没有查到数据
		{
			System.out.println("出现异常：" + e.getMessage());
			return false;
		}

		question.setChargeTypeId(chargeTypeId);
		question.setEditDate(new Timestamp(System.currentTimeMillis()));
		question.setCount(0);
		question.setDeleteFlag("0");

		try
		{
			mapper.insertOneChargeTypeQuestion(question);
		}
		catch (Exception e)
		{
			System.out.println("出现异常：" + e.getMessage());
			return false;
		}

		return true;
	}
}