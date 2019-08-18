package com.hyg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 案例表
 */
@Data
public class Case
{
	private Integer id;

	private Integer chargeId;

	private String title;

	private String desc;

	private String process;

	private String result;

	private String lessions;

	private String publishDate;

	private Integer isSuccess;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Timestamp editDate;

	private Integer count;

	private String deleteFlag;
}