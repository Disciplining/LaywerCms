package com.hyg.service;

import com.hyg.mapper.GetDataMapper;
import com.hyg.pojo.*;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("getTableServiceImpl")
public class GetTableServiceImpl implements GetTableService
{
	@Autowired
	@Qualifier("getDataMapper")
	private GetDataMapper getDataMapper;

	/*====================================================================================*/

	/**
	 * 获得团队文集 json数据 对应的对象
	 *
	 * @return
	 */
	@Override
	public RespondJson<ArticleExpand> getArticleData()
	{
		List<Article> articles = getDataMapper.listArticles(); // 文集数据
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

	/**
	 * 获得轮播图json数据 对应的对象
	 *
	 * @return
	 */
	@Override
	public RespondJson<Carousel> getCarouselData()
	{
		List<Carousel> list = getDataMapper.listCarousels();

		RespondJson<Carousel> json = new RespondJson<>();
		json.setCode(0);
		json.setMsg(null);
		json.setCount((long)list.size());
		json.setData(list);

		return json;
	}

	/**
	 * 获得留言表 json数据 对应的对象
	 *
	 * @return
	 */
	@Override
	public RespondJson<MsgBoard> getMsgBoardData()
	{
		List<MsgBoard> list = getDataMapper.listMsgBoards();

		RespondJson<MsgBoard> json = new RespondJson<>();
		json.setCode(0);
		json.setMsg("");
		json.setCount((long)list.size());
		json.setData(list);

		return json;
	}

	/**
	 * 获得所有的登录用户 的所有字段
	 *
	 * @return
	 */
	@Override
	public RespondJson<User> getUserData()
	{
		List<User> list = getDataMapper.listUsers();

		RespondJson<User> json = new RespondJson<>();

		json.setCode(0);
		json.setMsg(null);
		json.setCount((long)list.size());
		json.setData(list);

		return json;
	}

	/**
	 * 事务所表
	 * @return
	 */
	@Override
	public RespondJson<Agency> getAgencyData()
	{
		List<Agency> list = getDataMapper.getAgency();

		RespondJson<Agency> json = new RespondJson<>();

		json.setCode(0);
		json.setMsg(null);
		json.setCount((long)list.size());
		json.setData(list);

		return json;
	}

	/**
	 * 律师表
	 *
	 * @return
	 */
	@Override
	public RespondJson<Lawyer> getLawyerData()
	{
		List<Lawyer> list = getDataMapper.listLawyers();

		RespondJson<Lawyer> json = new RespondJson<>();

		json.setCode(0);
		json.setMsg(null);
		json.setCount((long)list.size());
		json.setData(list);

		return json;
	}
}