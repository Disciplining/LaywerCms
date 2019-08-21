package com.hyg.pojo.extend;

import com.hyg.pojo.ChargeTypeQuestion;
import lombok.Data;

@Data
public class ChargeTypeQuestionExtend extends ChargeTypeQuestion
{
//	private Integer id;
//	private Integer chargeTypeId;
//	private String question;
//	private String answer;
//	private Timestamp editDate;
//	private Integer count;
//	private String deleteFlag;

	private String chargeTypeName;

	public ChargeTypeQuestionExtend() {}

	public ChargeTypeQuestionExtend(ChargeTypeQuestion question, String chargeTypeName)
	{
		super(question.getId(), question.getChargeTypeId(), question.getQuestion(), question.getAnswer(), question.getEditDate(), question.getCount(), question.getDeleteFlag());
		this.chargeTypeName = chargeTypeName;
	}
}