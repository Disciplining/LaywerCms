package com.hyg.service.impl;

import com.hyg.mapper.LawyerMapper;
import com.hyg.pojo.Lawyer;
import com.hyg.service.LawyerService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lawyerServiceImpl")
public class LawyerServiceImpl implements LawyerService
{
	@Autowired
	@Qualifier("lawyerMapper")
	private LawyerMapper lawyerMapper;

	/**
	 * 获得符合前端格式的
	 * 留言表的数据
	 *
	 * @return
	 */
	@Override
	public RespondJson<Lawyer> getLawyerData()
	{
		List<Lawyer> list = lawyerMapper.listLawyers();

		RespondJson<Lawyer> json = new RespondJson<>();

		json.setCode(0);
		json.setMsg(null);
		json.setCount(list.size());
		json.setData(list);

		return json;
	}
}