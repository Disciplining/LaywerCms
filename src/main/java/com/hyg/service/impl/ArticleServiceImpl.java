package com.hyg.service.impl;

import com.github.pagehelper.PageHelper;
import com.hyg.mapper.ArticleMapper;
import com.hyg.pojo.Article;
import com.hyg.pojo.extend.ArticleExpand;
import com.hyg.service.ArticleService;
import com.hyg.util.respond.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("articleServiceImpl")
public class ArticleServiceImpl implements ArticleService
{
	@Autowired
	@Qualifier("articleMapper")
	private ArticleMapper articleMapper;

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
				article.setType(Article.ArticleType.CRIMINAL_LAW);
				break;
			}
			default:
			{
				return false;
			}
		}

		// 后端生成的数据
		article.setEditDate(new Timestamp(System.currentTimeMillis()));

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
				article.setType(Article.ArticleType.CRIMINAL_LAW);
				break;
			}
			default:
			{
				return false;
			}
		}

		// 后端生成的数据
		article.setEditDate(new Timestamp(System.currentTimeMillis()));
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
	 * 分页数据
	 * @param author
	 * @return
	 */
	@Override
	public RespondJson<ArticleExpand> listPageData(int pageNum, int pageSize, String author, String typeExpand)
	{
		Map<String, Object> par = new HashMap<>(2);
		par.put("author", author);
		switch (typeExpand)
		{
			case ArticleExpand.TypeExpand.COMPANY_LAW_STRING:
			{
				par.put("type", Article.ArticleType.COMPANY_LAW);
				break;
			}
			case ArticleExpand.TypeExpand.LABOUR_LAW_STRING:
			{
				par.put("type", Article.ArticleType.LABOUR_LAW);
				break;
			}
			case ArticleExpand.TypeExpand.CRIMINAL_LAW_STRING:
			{
				par.put("type", Article.ArticleType.CRIMINAL_LAW);
				break;
			}
			case "": // 没有传类型
			{
				par.put("type", "");
				break;
			}
		}

		List<Article> length = articleMapper.listArticlesByAuthor(par); // 开始分页前获取一次 为了长度

		PageHelper.startPage(pageNum, pageSize);
		List<Article> articles = articleMapper.listArticlesByAuthor(par);

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
					temp.setTypeExpand(ArticleExpand.TypeExpand.COMPANY_LAW_STRING);
					break;
				}
				case Article.ArticleType.LABOUR_LAW:
				{
					temp.setTypeExpand(ArticleExpand.TypeExpand.LABOUR_LAW_STRING);
					break;
				}
				case Article.ArticleType.CRIMINAL_LAW:
				{
					temp.setTypeExpand(ArticleExpand.TypeExpand.CRIMINAL_LAW_STRING);
					break;
				}
			}

			list.add(temp);
		}

		RespondJson<ArticleExpand> json = new RespondJson<>();

		json.setCode(0);
		json.setCount(length.size());
		json.setMsg(null);
		json.setData(list);

		return json;
	}

	/**
	 * 根据id获得一篇文章
	 *
	 * @param id
	 * @return
	 */
	@Override
	public RespondJson<ArticleExpand> getOneArticleById(int id)
	{
		Article article = articleMapper.getOneArticleById(id); // 查询文章

		if (article != null) // 有这篇文章
		{
			ArticleExpand articleExpand = new ArticleExpand();
			articleExpand.setArticleId(article.getArticleId());
			switch (article.getType())
			{
				case Article.ArticleType.COMPANY_LAW:
				{
					articleExpand.setTypeExpand(ArticleExpand.TypeExpand.COMPANY_LAW_STRING);
					break;
				}
				case Article.ArticleType.LABOUR_LAW:
				{
					articleExpand.setTypeExpand(ArticleExpand.TypeExpand.LABOUR_LAW_STRING);
					break;
				}
				case Article.ArticleType.CRIMINAL_LAW:
				{
					articleExpand.setTypeExpand(ArticleExpand.TypeExpand.CRIMINAL_LAW_STRING);
					break;
				}
				default:
				{
					articleExpand.setTypeExpand("");
					break;
				}
			}
			articleExpand.setArticleTitle(article.getArticleTitle());
			articleExpand.setAuthor(article.getAuthor());
			articleExpand.setIntro(article.getIntro());
			articleExpand.setContent(article.getContent());
			articleExpand.setEditDate(article.getEditDate());
			articleExpand.setCount(article.getCount());
			articleExpand.setDeleteFlag(article.getDeleteFlag());


			List<ArticleExpand> list = new ArrayList<>(1);
			list.add(articleExpand);

			RespondJson<ArticleExpand> json = new RespondJson<>();
			json.setCode(0);
			json.setCount(1);
			json.setMsg(null);
			json.setData(list);

			return json;
		}
		else // 没有这篇文章
		{
			RespondJson<ArticleExpand> json = new RespondJson<>();
			json.setCode(0);
			json.setCount(0);
			json.setMsg(null);
			json.setData(null);

			return json;
		}
	}
}