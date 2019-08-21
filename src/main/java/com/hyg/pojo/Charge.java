package com.hyg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 罪名表
 */
@Data
public class Charge
{
	private Integer id;

	private Integer chargeTypeId;

	private String chargeName;

	private String lawContent;

	private String sentenceRange;

	private String defense;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Timestamp editDate;

	private Integer count;

	private String deleteFlag;

	public Charge() {}

	public Charge(Integer id, Integer chargeTypeId, String chargeName, String lawContent, String sentenceRange, String defense, Timestamp editDate, Integer count, String deleteFlag)
	{
		this.id = id;
		this.chargeTypeId = chargeTypeId;
		this.chargeName = chargeName;
		this.lawContent = lawContent;
		this.sentenceRange = sentenceRange;
		this.defense = defense;
		this.editDate = editDate;
		this.count = count;
		this.deleteFlag = deleteFlag;
	}
}