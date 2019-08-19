package com.hyg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 刑辩优势表
 */
@Data
public class DefenseAdvantage
{
	private Integer id;

	private String title;

	private String content;

	private String icon;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Timestamp editDate;

	private Integer count;

	private String deleteFlag;
}