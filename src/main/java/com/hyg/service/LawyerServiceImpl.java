package com.hyg.service;

import com.hyg.pojo.Lawyer;
import com.hyg.util.lead.RepObject;
import com.hyg.util.lead.Util;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Service("lawyerServiceImpl")
public class LawyerServiceImpl implements LawyerService
{
	/**
	 * 获得律师信息
	 * @return
	 */
	@Override
	@ResponseBody
	public RepObject getLawyerData()
	{
		/**
		 * 模拟从数据库中取数据
		 */
		List list = new ArrayList();
		for (int i = 1; i <= 50; i++)
		{
			Lawyer temp = new Lawyer();
			temp.setLawyerId(1);
			temp.setLawyerName("张三" + i);
			temp.setLawyerImg("http://xxxxx");
			temp.setIntroduction("律师介绍");

			list.add(temp);
		}

		return Util.getRepObject(list);
	}
}
