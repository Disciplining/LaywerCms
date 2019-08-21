package com.hyg.service;

import com.hyg.pojo.DefenseAdvantage;
import com.hyg.pojo.extend.DefenseAdvantageExpand;
import com.hyg.util.respond.RespondJson;

public interface DefenseAdvantageService
{
	/**
	 * 添加一条数据
	 * @param advantage
	 * @return
	 */
	boolean insertOneAdvantage(DefenseAdvantageExpand advantage);

	/**
	 * 编辑一条数据
	 * 前端传过来的数据：id、title、content、file
	 * 后端需要的数据：id*、title*、content*、icon、editDate
	 * @param expand
	 * @return
	 */
	boolean editOneDefenseAdvantage(DefenseAdvantageExpand expand);

	/**
	 * 分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	RespondJson<DefenseAdvantage> pageData(int pageNum, int pageSize);

	/**
	 * 根据id获得一条数据
	 * @param id
	 * @return
	 */
	RespondJson<DefenseAdvantage> getOneDefenseAdvantageById(int id);

	/**
	 * 根据id删除一条数据
	 * @param id
	 * @return
	 */
	boolean deleteOneDefenseAdvantageById(int id);
}