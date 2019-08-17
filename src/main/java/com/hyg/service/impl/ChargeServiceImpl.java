package com.hyg.service.impl;

import com.github.pagehelper.PageHelper;
import com.hyg.mapper.ChargeMapper;
import com.hyg.mapper.ChargeTypeMapper;
import com.hyg.pojo.Charge;
import com.hyg.service.ChargeService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service("chargeServiceImpl")
public class ChargeServiceImpl implements ChargeService
{
	@Autowired
	@Qualifier("chargeMapper")
	private ChargeMapper chargeMapper;

	@Autowired
	@Qualifier("chargeTypeMapper")
	private ChargeTypeMapper chargeTypeMapper;

	/**
	 * 添加一个罪名
	 * 前端传过来的数据：chargeTypeName    chargeName、lawContent、sentenceRange、defense
	 *
	 * @param charge
	 * @return
	 */
	@Override
	public boolean insertOneCharge(Charge charge, String chargeTypeName)
	{
		int chargeTypeId;

		try
		{
			chargeTypeId = chargeTypeMapper.getOneChargeTypeByName(chargeTypeName).getId(); // 根据前端传过来的罪名分类名称查询罪名分类id
		}
		catch (NullPointerException e) // 没有查询到罪名分类
		{
			return false;
		}

		charge.setChargeTypeId(chargeTypeId);
		charge.setEditDate(new Timestamp(System.currentTimeMillis()));
		charge.setCount(0);
		charge.setDeleteFlag("0");

		try
		{
			chargeMapper.insertOneCharge(charge);
		}
		catch (Exception e)
		{
			System.out.println("发生异常：" + e.getMessage());
			return false;
		}

		return true;
	}

	/**
	 * 罪名表分页数据
	 *
	 * @param pageNum
	 * @param pageSize
	 * @param chargeName
	 * @return
	 */
	@Override
	public RespondJson<Charge> chargePageData(int pageNum, int pageSize, String chargeName)
	{
		List<Charge> list = chargeMapper.listChargeByChargeName(chargeName); // 分页前查询，为了长度

		PageHelper.startPage(pageNum, pageSize);
		List<Charge> charges = chargeMapper.listChargeByChargeName(chargeName); // 分页数据

		return new RespondJson<>(0, null, list.size(), charges);
	}
}