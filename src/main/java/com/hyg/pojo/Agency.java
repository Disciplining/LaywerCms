package com.hyg.pojo;

import lombok.Data;

/**
 * 事务所表
 */
@Data
public class Agency
{
	private Integer id;
	private String agencyName;
	private String agencyImg;
	private String agencyDetail;
}