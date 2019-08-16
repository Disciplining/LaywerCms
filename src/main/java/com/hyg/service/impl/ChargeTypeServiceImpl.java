package com.hyg.service.impl;

import com.github.pagehelper.PageHelper;
import com.hyg.mapper.ChargeTypeMapper;
import com.hyg.pojo.ChargeType;
import com.hyg.service.ChargeTypeService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 罪名分类表 service
 */
@Service("chargeTypeServiceImpl")
public class ChargeTypeServiceImpl implements ChargeTypeService
{
	@Autowired
	@Qualifier("chargeTypeMapper")
	private ChargeTypeMapper chargeTypeMapper;

	/**
	 * 添加一个罪名分类
	 * 前端传来的数据：chargeTypeName
	 * 需要添加的数据：chargeTypeName、editDate、count、deleteFlag
	 * @param chargeType
	 * @return
	 */
	@Override
	public boolean insertOneChargeType(ChargeType chargeType)
	{
		chargeType.setEditDate(new Timestamp(System.currentTimeMillis()));
		chargeType.setCount(0);
		chargeType.setDeleteFlag("0");

		try
		{
			chargeTypeMapper.insertOneChargeType(chargeType);
		}
		catch (Exception e)
		{
			System.out.println("++++++++++++++发生异常++++++++++++++");
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * 罪名分类表 分页数据
	 *
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public RespondJson<ChargeType> charTypePageData(int pageNum, int pageSize)
	{
		List<ChargeType> list = chargeTypeMapper.listAllChargeType(); // 分页前查询，为了长度

		PageHelper.startPage(pageNum, pageSize);
		List<ChargeType> chargeTypes = chargeTypeMapper.listAllChargeType();

		return new RespondJson<>(0, null, list.size(), chargeTypes);
	}

	/**
	 * 根据id获得一个罪名分类
	 *
	 * @param id
	 * @return
	 */
	@Override
	public RespondJson<ChargeType> getOneChargeTypeById(int id)
	{
		ChargeType type = chargeTypeMapper.getOneChargeTypeById(id);

		if (type != null)
		{
			List<ChargeType> list = new ArrayList<>(1);
			list.add(type);

			return new RespondJson<>(0, null, list.size(), list);
		}
		else
		{
			return new RespondJson<>(0, null, 0, new ArrayList<>(0));
		}
	}

	/**
	 * 编辑一个罪名类型
	 * 前端需要传过来的数据：id、chargeTypeName
	 * 需要更新的数据：chargeTypeName
	 * @param chargeType
	 * @return
	 */
	@Override
	public boolean editChargeType(ChargeType chargeType)
	{
		try
		{
			chargeTypeMapper.updateChargeTypeNameById(chargeType);
		}
		catch (Exception e)
		{
			System.out.println("发生了异常：" + e.getMessage());
			return false;
		}

		return true;
	}
}