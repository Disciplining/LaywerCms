package com.hyg.service.impl;

import com.hyg.mapper.DefenseDescMapper;
import com.hyg.pojo.DefenseDesc;
import com.hyg.service.DefenseDescService;
import com.hyg.util.respond.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service("defenseDescServiceImpl")
public class DefenseDescServiceImpl implements DefenseDescService
{
	@Autowired
	@Qualifier("defenseDescMapper")
	private DefenseDescMapper mapper;

	/**
	 * 获得刑辨介绍表中的数据  只有一条数据
	 *
	 * @return
	 */
	@Override
	public RespondJson<DefenseDesc> listDefenseDesc()
	{
		List<DefenseDesc> list = mapper.listDefenseDesc();

		return new RespondJson<>(0, null, list.size(), list);
	}

	/**
	 * 更新刑辨介绍
	 * 前端传过来的数据：desc
	 * 后端需要的数据：desc、editDate
	 *
	 * @param defenseDesc
	 * @return
	 */
	@Override
	public boolean updateDesc(DefenseDesc defenseDesc)
	{
		defenseDesc.setEditDate(new Timestamp(System.currentTimeMillis()));

		try
		{
			mapper.updateDesc(defenseDesc);
		}
		catch (Exception e)
		{
			System.out.println("出现异常：" + e.getMessage());
			return false;
		}

		return true;
	}
}