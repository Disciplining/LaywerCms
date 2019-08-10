package com.hyg.service;

import com.hyg.mapper.SelectMapper;
import com.hyg.pojo.*;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("selectServiceImpl")
public class SelectServiceImpl implements SelectService
{
	@Autowired
	@Qualifier("selectMapper")
	private SelectMapper selectMapper;

	/*====================================================================================*/

	/**
	 * 获得团队文集 json数据 对应的对象
	 *
	 * @return
	 */
	@Override
	public RespondJson<ArticleExpand> getArticleData()
	{
		List<Article> articles = selectMapper.listArticles(); // 文集数据
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
		List<Carousel> list = selectMapper.listCarousels();

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
		List<MsgBoard> list = selectMapper.listMsgBoards();

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
		List<User> list = selectMapper.listUsers();

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
		List<Agency> list = selectMapper.getAgency();

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
		List<Lawyer> list = selectMapper.listLawyers();

		RespondJson<Lawyer> json = new RespondJson<>();

		json.setCode(0);
		json.setMsg(null);
		json.setCount((long)list.size());
		json.setData(list);

		return json;
	}

	@Override
	public RespondJson<Menu> getMenuData()
	{
		List<Menu> list = selectMapper.listMenus();

		RespondJson<Menu> json = new RespondJson<>();

		json.setCode(0);
		json.setMsg(null);
		json.setCount((long)list.size());
		json.setData(list);

		return json;
	}
}