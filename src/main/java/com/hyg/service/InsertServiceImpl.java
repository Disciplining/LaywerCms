package com.hyg.service;

import com.hyg.mapper.InsertMapper;
import com.hyg.pojo.Article;
import com.hyg.pojo.ArticleExpand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service("insertServiceImpl")
public class InsertServiceImpl implements InsertService
{
	@Autowired
	@Qualifier("insertMapper")
	private InsertMapper insertMapper;

	/**
	 * 团队文集表
	 *
	 * @param articleExpand
	 * @return
	 */
	@Override
	public boolean insertTableArticle(ArticleExpand articleExpand)
	{
		Article article = new Article();

		// 前端传过来的数据
		article.setArticleTitle(articleExpand.getArticleTitle());
		article.setAuthor(articleExpand.getAuthor());
		article.setIntro(articleExpand.getIntro());
		article.setContent(articleExpand.getContent());
		switch (articleExpand.getTypeExpand())
		{
			case "公司法律":
			{
				article.setType(Article.ArticleType.COMPANY_LAW);
				break;
			}
			case "劳动法律":
			{
				article.setType(Article.ArticleType.LABOUR_LAW);
				break;
			}
			case "形式法律":
			{
				article.setType(Article.ArticleType.FORMAL_LAW);
				break;
			}
			default:
			{
				return false;
			}
		}

		// 后端生成的数据
		article.setEditDate(new Date(System.currentTimeMillis()));
		article.setCount(0);
		article.setDeleteFlag("false");

		try
		{
			insertMapper.insertOneArticle(article);
		}
		catch (Exception e)
		{
			return false;
		}

		return true;
	}
}