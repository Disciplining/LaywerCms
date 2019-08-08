package com.hyg.pojo;

import lombok.Data;

/**
 * 团队文集表
 */
@Data
public class Article
{
	private Integer articleId;
	private Integer type;
	private Integer articleTitle;
	private Integer author;
	private Integer intro;
	private Integer content;
	private Integer editDate;
	private Integer count;

	public static class ArticleType
	{
		public static final Integer COMPANY_LAW = 1;
		public static final Integer LABOUR_LAW = 2;
		public static final Integer FORMAL_LAW = 3;
	}
}