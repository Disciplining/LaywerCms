package com.hyg.pojo;

import lombok.Data;

import java.sql.Date;

/**
 * 轮播图表
 */
@Data
public class Carousel
{
	private Integer id;
	private String bannerName;
	private String imgPath;
	private Date editDate;
}