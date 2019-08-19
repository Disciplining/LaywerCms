package com.hyg.service.impl;

import com.github.pagehelper.PageHelper;
import com.hyg.mapper.CaseMapper;
import com.hyg.mapper.ChargeMapper;
import com.hyg.mapper.ChargeTypeMapper;
import com.hyg.pojo.Case;
import com.hyg.service.CaseService;
import com.hyg.util.respond.CaseLinkageData;
import com.hyg.util.respond.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service("caseServiceImpl")
public class CaseServiceImpl implements CaseService
{

	@Autowired
	@Qualifier("chargeTypeMapper")
	private ChargeTypeMapper chargeTypeMapper;

	@Autowired
	@Qualifier("chargeMapper")
	private ChargeMapper chargeMapper;

	@Autowired
	@Qualifier("caseMapper")
	private CaseMapper mapper;

	/**
	 * 获得添加案例时的联运数据
	 *
	 * @return
	 */
	@Override
	public RespondJson<CaseLinkageData> getLinkageDate()
	{
		List<CaseLinkageData> data = new ArrayList<>();

		try
		{
			List<String> allTypeName = chargeTypeMapper.listChargeTypeName();
			for (String typeName : allTypeName)
			{
				CaseLinkageData temp = new CaseLinkageData();
				temp.setChargeTypeName(typeName);

				int chargeTypeId = chargeTypeMapper.getOneChargeTypeByName(typeName).getId();
				List chargeNames = chargeMapper.listChargeNameByChargeTypeId(chargeTypeId);
				if (chargeNames.size() > 0)
				{
					temp.setChargeNames(chargeNames);

					data.add(temp);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("出现了异常：" + e.getMessage());

			data = new ArrayList<>(0);
		}

		return new RespondJson<>(0, null, data.size(), data);
	}

	/**
	 * 添加一个案例
	 * 前端传过来的数据：
	 *
	 * chargeName 罪名名称
	 *
	 * title        案例标题
	 * desc         案例介绍
	 * process      办案过程
	 * result       结果
	 * lessions     经验心得
	 * successFlag  是否成功 1:0
	 *
	 * @param oneCase
	 * @param chargeName
	 * @return
	 */
	@Override
	public boolean insertOneCase(Case oneCase, String chargeName)
	{
		int chargeId;

		try
		{
			chargeId  = chargeMapper.getOneChargeByChargeName(chargeName).getId();
		}
		catch (Exception e)
		{
			System.out.println("发生异常：" + e.getMessage());
			return false;
		}

		/*--------------------前端没有传过来的数据-------------------------*/
		oneCase.setChargeId(chargeId);
		oneCase.setPublishDate(new Timestamp(System.currentTimeMillis())); // 发布时间，就是添加数据时的时间
		oneCase.setEditDate(new Timestamp(System.currentTimeMillis()));
		oneCase.setCount(0);
		oneCase.setDeleteFlag("0");
		/*--------------------------------------------------------------*/

		try
		{
			mapper.insertOneDate(oneCase);
		}
		catch (Exception e)
		{
			System.out.println("发生异常：" + e.getMessage());
			return false;
		}

		return true;
	}

	/**
	 * 分页数据
	 *
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public RespondJson<Case> pageDate(int pageNum, int pageSize)
	{
		List<Case> list = mapper.listAllCase(); // 分页前查询，为了长度

		PageHelper.startPage(pageNum, pageSize);
		List<Case> cases = mapper.listAllCase();

		return new RespondJson<>(0, null, list.size(), cases);
	}

	/**
	 * 根据id获得一个案例
	 *
	 * @param id
	 * @return
	 */
	@Override
	public RespondJson<Case> getOneCaseById(int id)
	{
		Case oneCase = mapper.getOneCaseById(id);

		if (oneCase != null)
		{
			List<Case> list = new ArrayList<>(1);
			list.add(oneCase);

			return new RespondJson<>(0, null, list.size(), list);
		}
		else
		{
			return new RespondJson<>(0, null, 0, new ArrayList<>(0));
		}
	}

	/**
	 * 根据id删除一个案例
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteOneCaseById(int id)
	{
		try
		{
			mapper.deleteOneCaseById(id);
		}
		catch (Exception e)
		{
			System.out.println("出现异常：" + e.getMessage());
			return false;
		}

		return true;
	}

	/**
	 * 编辑一个案例
	 * 前端传过来的数据：chargeName， id title desc process result lessions successFlag
	 * 后端需要的数据： id* chargeId title* desc* process* result* lessions* successFlag* editDate
	 * @param oneCase
	 * @return
	 */
	@Override
	public boolean editOneCase(Case oneCase, String chargeName)
	{
		int chargeId;

		try
		{
			chargeId  = chargeMapper.getOneChargeByChargeName(chargeName).getId();
		}
		catch (Exception e)
		{
			System.out.println("发生异常：" + e.getMessage());
			return false;
		}

		oneCase.setChargeId(chargeId);
		oneCase.setEditDate(new Timestamp(System.currentTimeMillis()));

		try
		{
			mapper.updateEditOneCase(oneCase);
		}
		catch (Exception e)
		{
			System.out.println("发生了异常：" + e.getMessage());
		}

		return true;
	}
}