package com.hyg.service;

import com.hyg.mapper.ArticleMapper;
import com.hyg.pojo.Article;
import com.hyg.pojo.ArticleExpand;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("articleServiceImpl")
public class ArticleServiceImpl implements ArticleService
{
	@Autowired
	@Qualifier("articleMapper")
	private ArticleMapper articleMapper;

	/**
	 * 获得团队文集 json数据 对应的对象
	 *
	 * @return
	 */
	@Override
	public RespondJson<ArticleExpand> getCarouselData()
	{
		List<Article> articles = articleMapper.listArticles(); // 文集数据
		List<ArticleExpand> list = new ArrayList<>(articles.size());


		// 将拿到的数据转换为前端的形式
		for (Article foo : articles)
		{
			System.out.println(foo);
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
		json.setCount((long)list.size());
		json.setMsg(null);
		json.setData(list);

		return json;
	}
}