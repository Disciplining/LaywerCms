package com.hyg.service;

import com.hyg.pojo.DefenseDesc;
import com.hyg.util.respond.RespondJson;

public interface DefenseDescService
{
	/**
	 * 更新刑辨介绍
	 * 前端传过来的数据：desc
	 * 后端需要的数据：desc、editDate
	 * @param defenseDesc
	 * @return
	 */
	boolean updateDesc(DefenseDesc defenseDesc);

	/**
	 * 获得刑辨介绍表中的数据  只有一条数据
	 * @return
	 */
	RespondJson<DefenseDesc> listDefenseDesc();
}