package com.hyg.service;

import com.hyg.mapper.InsertMapper;
import com.hyg.pojo.Article;
import com.hyg.pojo.ArticleExpand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("insertTableDataServiceImpl")
public class InsertTableDataServiceImpl implements InsertTableDataService
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
		Article article = articleExpand;

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


		System.out.println("++++++++++ www.baidu.com ++++++++++ debug:" + article);

//		insertMapper.insertOneArticle(article);

		return true;
	}
}