package com.hyg.pojo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class DefenseAdvantageExpand extends DefenseAdvantage
{
//	private Integer id;
//	private String title;
//	private String content;
//	private String icon;
//	private Timestamp editDate;
//	private Integer count;
//	private String deleteFlag;

	private MultipartFile file; // icon图片
}