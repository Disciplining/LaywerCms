package com.hyg.pojo;

import lombok.Data;

import java.sql.Date;

/**
 * 团队文集表
 */
@Data
public class Article
{
	private Integer articleId;
	private Integer type;
	private String articleTitle;
	private String author;
	private String intro;
	private String content;
	private Date editDate;
	private Integer count;
	private String deleteFlag;

	public static class ArticleType
	{
		public static final int COMPANY_LAW = 1; // 公司法律
		public static final int LABOUR_LAW = 2; // 劳动法律
		public static final int FORMAL_LAW = 3; // 形式法律
	}
}