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
}

class ArticleType
{
	public static final String COMPANY_LAW = "公司法律";
	public static final String LABOUT_LAW = "公司法律";
	public static final String FORMAL_LAW = "公司法律";
}