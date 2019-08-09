package com.hyg.pojo;

import lombok.Data;

/**
 * 律师表
 */
@Data
public class Lawyer
{
	private Integer lawyerId;
	private String lawyerName;
	private String lawyerLevel;
	private String introduction;
	private String lawyerImg;
	private String graduate;
	private String major;
	private String achievement;
	private String customers;
	private String deleteFlag;
}