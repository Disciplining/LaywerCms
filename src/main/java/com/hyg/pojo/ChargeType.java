package com.hyg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 罪名分类表
 */
@Data
public class ChargeType
{
	 private Integer id;

	 private String chargeTypeName;

	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	 private Timestamp editDate;

	 private Integer count;

	 private String deleteFlag;
}