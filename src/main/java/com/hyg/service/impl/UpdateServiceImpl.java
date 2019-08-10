package com.hyg.service.impl;

import com.hyg.mapper.UpdateMapper;
import com.hyg.pojo.Article;
import com.hyg.pojo.ArticleExpand;
import com.hyg.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * 根据主键
 * 更新表
 * 除了自增字段 都更新
 */
@Service("updateServiceImpl")
public class UpdateServiceImpl implements UpdateService
{
	@Autowired
	@Qualifier("updateMapper")
	private UpdateMapper updateMapper;

	/**
	 * 团队文集表
	 *
	 * @param articleExpand 用户传过来的数据
	 * @return
	 */
	@Override
	public boolean updateTableArticle(ArticleExpand articleExpand)
	{
		Article article = new Article();

		// 前端传过来的数据
		article.setArticleId(articleExpand.getArticleId());
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

		try
		{
			updateMapper.updateArticle(article);
		}
		catch (Exception e)
		{
			return false;
		}


		return true;
	}
}