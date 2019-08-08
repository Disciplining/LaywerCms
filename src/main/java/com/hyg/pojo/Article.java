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
	private String deleteFlag;

	public static class ArticleType
	{
		public static final Integer COMPANY_LAW = 1; // 公司法律
		public static final Integer LABOUR_LAW = 2; // 劳动法律
		public static final Integer FORMAL_LAW = 3; // 形式法律
	}
}