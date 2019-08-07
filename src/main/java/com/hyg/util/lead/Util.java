package com.hyg.util.lead;

import com.hyg.pojo.Lawyer;

import java.util.ArrayList;
import java.util.List;

public class Util
{
	/**
	 * 将数据库中取出的律师对象转换成返回给前端的数据
	 * @param lawyers
	 * @return
	 */
	public static RepObject getRepObject(List<Lawyer> lawyers)
	{
		List<LawyerRep> lawyerReps = new ArrayList<>(lawyers.size());
		for (Lawyer item : lawyers)
		{
			LawyerRep temp = new LawyerRep();
			temp.setId(item.getLawyerId());
			temp.setImg(item.getLawyerImg());
			temp.setName(item.getLawyerName());
			temp.setProfess("这个字段数据库中没有");
			temp.setIntro(item.getIntroduction());

			lawyerReps.add(temp);
		}

		RepObject object = new RepObject();
		object.setData(lawyerReps);

		return object;
	}
}