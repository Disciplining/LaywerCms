package com.hyg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 罪名分类问答表
 */
@Data
public class ChargeTypeQuestion
{
	private Integer id;

	private Integer chargeTypeId;

	private String question;

	private String answer;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Timestamp editDate;

	private Integer count;

	private String deleteFlag;

	public ChargeTypeQuestion() {}

	public ChargeTypeQuestion(Integer id, Integer chargeTypeId, String question, String answer, Timestamp editDate, Integer count, String deleteFlag)
	{
		this.id = id;
		this.chargeTypeId = chargeTypeId;
		this.question = question;
		this.answer = answer;
		this.editDate = editDate;
		this.count = count;
		this.deleteFlag = deleteFlag;
	}
}