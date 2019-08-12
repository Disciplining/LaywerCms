package com.hyg.service.impl;

import com.hyg.mapper.AgencyMapper;
import com.hyg.pojo.Agency;
import com.hyg.service.AgencyService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("agencyServiceImpl")
public class AgencyServiceImpl implements AgencyService
{
	@Autowired
	@Qualifier("agencyMapper")
	private AgencyMapper agencyMapper;

	/**
	 * 获得前端需要的格式的事务所表的信息
	 * @return
	 */
	@Override
	public RespondJson<Agency> getAgencyData()
	{
		List<Agency> list = agencyMapper.listAgency();

		RespondJson<Agency> json = new RespondJson<>();

		json.setCode(0);
		json.setMsg(null);
		json.setCount(list.size());
		json.setData(list);

		return json;
	}

	/**
	 * 修改事务所介绍
	 *
	 * @param detail
	 * @return
	 */
	@Override
	public boolean updateAgencyDetail(String detail)
	{
		try
		{
			agencyMapper.updateAgencyDetail(detail);
		}
		catch (Exception e)
		{
			System.out.println("++++++++++++++++++++发生异常++++++++++++++++++++");
			return false;
		}

		return true;
	}
}
