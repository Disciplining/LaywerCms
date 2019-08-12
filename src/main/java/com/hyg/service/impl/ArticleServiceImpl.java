package com.hyg.service.impl;

import com.hyg.mapper.ArticleMapper;
import com.hyg.pojo.Article;
import com.hyg.pojo.ArticleExpand;
import com.hyg.service.ArticleService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service("articleServiceImpl")
public class ArticleServiceImpl implements ArticleService
{
	@Autowired
	@Qualifier("articleMapper")
	private ArticleMapper articleMapper;

	/**
	 * 获得前端需要的格式的
	 * 团队文集表的所有数据
	 * @return
	 */
	@Override
	public RespondJson<ArticleExpand> getArticleData()
	{
		List<Article> articles = articleMapper.listArticles(); // 文集数据
		List<ArticleExpand> list = new ArrayList<>(articles.size());

		// 将拿到的数据转换为前端的形式
		for (Article foo : articles)
		{
			ArticleExpand temp = new ArticleExpand();
			temp.setArticleId(foo.getArticleId());
			temp.setType(foo.getType());
			temp.setArticleTitle(foo.getArticleTitle());
			temp.setAuthor(foo.getAuthor());
			temp.setIntro(foo.getIntro());
			temp.setContent(foo.getContent());
			temp.setEditDate(foo.getEditDate());
			temp.setCount(foo.getCount());
			temp.setDeleteFlag(foo.getDeleteFlag());

			switch (foo.getType())
			{
				case Article.ArticleType.COMPANY_LAW:
				{
					temp.setTypeExpand("公司法律");
					break;
				}
				case Article.ArticleType.LABOUR_LAW:
				{
					temp.setTypeExpand("劳动法律");
					break;
				}
				case Article.ArticleType.FORMAL_LAW:
				{
					temp.setTypeExpand("形式法律");
					break;
				}
			}

			list.add(temp);
		}

		RespondJson<ArticleExpand> json = new RespondJson<>();

		json.setCode(0);
		json.setCount(list.size());
		json.setMsg(null);
		json.setData(list);

		return json;
	}

	/**
	 * 编辑团队文集
	 *
	 * @param articleExpand 用户传过来的数据
	 * @return
	 */
	@Override
	public boolean editOneArticle(ArticleExpand articleExpand)
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
			articleMapper.updateOneArticleById(article);
		}
		catch (Exception e)
		{
			return false;
		}


		return true;
	}

	/**
	 * 新增一条团队文集数据
	 *
	 * @param articleExpand 用户传过来的数据
	 * @return
	 */
	@Override
	public boolean insertOneArticle(ArticleExpand articleExpand)
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
		article.setDeleteFlag("0");

		// debug
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try
		{
			articleMapper.insertOneArticle(article);
			System.out.println(article);
		}
		catch (Exception e)
		{
			return false;
		}

		return true;
	}

	/**
	 * 根据id
	 * 删除团队文集表中的一条数据
	 * @param id
	 */
	@Override
	public boolean deleteOneArticleById(int id)
	{
		try
		{
			articleMapper.deleteOneArticleById(id);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * 根据作者查找文集
	 *
	 * @param author
	 * @return
	 */
	@Override
	public RespondJson<ArticleExpand> listArticlesByAuthor(String author)
	{
		List<Article> articles = articleMapper.listArticlesByAuthor(author);

		List<ArticleExpand> list = new ArrayList<>(articles.size());

		// 将拿到的数据转换为前端的形式
		for (Article foo : articles)
		{
			ArticleExpand temp = new ArticleExpand();
			temp.setArticleId(foo.getArticleId());
			temp.setType(foo.getType());
			temp.setArticleTitle(foo.getArticleTitle());
			temp.setAuthor(foo.getAuthor());
			temp.setIntro(foo.getIntro());
			temp.setContent(foo.getContent());
			temp.setEditDate(foo.getEditDate());
			temp.setCount(foo.getCount());
			temp.setDeleteFlag(foo.getDeleteFlag());

			switch (foo.getType())
			{
				case Article.ArticleType.COMPANY_LAW:
				{
					temp.setTypeExpand("公司法律");
					break;
				}
				case Article.ArticleType.LABOUR_LAW:
				{
					temp.setTypeExpand("劳动法律");
					break;
				}
				case Article.ArticleType.FORMAL_LAW:
				{
					temp.setTypeExpand("形式法律");
					break;
				}
			}

			list.add(temp);
		}

		RespondJson<ArticleExpand> json = new RespondJson<>();

		json.setCode(0);
		json.setCount(list.size());
		json.setMsg(null);
		json.setData(list);

		return json;
	}
}