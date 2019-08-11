package com.hyg.service;

import com.hyg.pojo.Lawyer;
import com.hyg.pojo.LawyerExpand;
import com.hyg.util.RespondJson;

public interface LawyerService
{
	/**
	 * 获得符合前端格式的
	 * 留言表的数据
	 * @return
	 */
	RespondJson<Lawyer> getLawyerData();

	/**
	 * 添加一个律师
	 * @param lawyerExpand
	 */
	boolean insertOneLawyer (LawyerExpand lawyerExpand);
}