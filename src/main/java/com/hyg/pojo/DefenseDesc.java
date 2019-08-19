package com.hyg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 刑辨介绍表
 */
@Data
public class DefenseDesc
{
	private Integer id;

	private String desc;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Timestamp editDate;

	private Integer count;

	private String deleteFlag;
}