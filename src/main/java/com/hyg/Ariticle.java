package com.hyg;

import java.sql.Date;

public class Ariticle
{
	private Integer articleId;
	private Integer	type;
	private String articleTitle;
	private String author;
	private String intro;
	private	String content;
	private Date editDate;
	private Integer	count;

	public Integer getArticleId()
	{
		return articleId;
	}

	public void setArticleId(Integer articleId)
	{
		this.articleId = articleId;
	}

	public Integer getType()
	{
		return type;
	}

	public void setType(Integer type)
	{
		this.type = type;
	}

	public String getArticleTitle()
	{
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle)
	{
		this.articleTitle = articleTitle;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getIntro()
	{
		return intro;
	}

	public void setIntro(String intro)
	{
		this.intro = intro;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Date getEditDate()
	{
		return editDate;
	}

	public void setEditDate(Date editDate)
	{
		this.editDate = editDate;
	}

	public Integer getCount()
	{
		return count;
	}

	public void setCount(Integer count)
	{
		this.count = count;
	}
}