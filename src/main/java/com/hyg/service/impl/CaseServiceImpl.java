package com.hyg.service.impl;

import com.hyg.mapper.ChargeMapper;
import com.hyg.mapper.ChargeTypeMapper;
import com.hyg.service.CaseService;
import com.hyg.util.respond.CaseLinkageData;
import com.hyg.util.respond.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
}
