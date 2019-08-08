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
	private Boolean deleteFlag;

	public static class LawyerLevel
	{
		public static final String CHIEF_LAWYER = "主任律师";
		public static final String PRACTICING_LAWYER = "执业律师";
		public static final String APPRENTICE_LAWYER = "实习律师";
		public static final String ASSISTANT_LAWYER = "助理律师";
	}
}