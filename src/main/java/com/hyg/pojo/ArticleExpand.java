package com.hyg.pojo;

import lombok.Data;

@Data
public class ArticleExpand extends Article
{
//	private Integer articleId;
//	private Integer type;
//	private String articleTitle;
//	private String author;
//	private String intro;
//	private String content;
//	private Date editDate;
//	private Integer count;
//	private String deleteFlag;
	private String typeExpand;

	public class TypeExpand
	{
		public static final String COMPANY_LAW_STRING = "公司法律"; // 1
		public static final String LABOUR_LAW_STRING = "劳动法律"; // 2
		public static final String CRIMINAL_LAW_STRING = "刑事法律"; // 3
	}
}
