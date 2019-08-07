package com.hyg.util.lead;

import lombok.Data;

/**
 * 将律师对象转换成这个对象
 */
@Data
public class LawyerRep
{
	private Integer id;
	private String img;
	private String name;
	private String profess;
	private String intro;
}