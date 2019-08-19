package com.hyg.service;

import com.hyg.pojo.Case;
import com.hyg.util.respond.CaseLinkageData;
import com.hyg.util.respond.RespondJson;

/**
 * 案例表
 */
public interface CaseService
{
	/**
	 * 获得添加案例时的联运数据
	 * @return
	 */
	RespondJson<CaseLinkageData> getLinkageDate();

	/**
	 * 添加一个案例
	 * 前端传过来的数据：
	 * chargeName 罪名名称
	 *
	 * title      案例标题
	 * desc       案例介绍
	 * process    办案过程
	 * @param onCase
	 * @return
	 */
	boolean insertOneCase(Case onCase, String chargeName);

	/**
	 * 分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	RespondJson<Case> pageDate(int pageNum, int pageSize);

	/**
	 * 根据id获得一个案例
	 * @param id
	 * @return
	 */
	RespondJson<Case> getOneCaseById(int id);

	/**
	 * 根据id删除一个案例
	 * @param id
	 * @return
	 */
	boolean deleteOneCaseById(int id);

	/**
	 * 编辑一个案例
	 * 前端传过来的数据：chargeName， id title desc process result lessions successFlag
	 * 后端需要的数据： id* chargeId title* desc* process* result* lessions* successFlag* editDate
	 * @param oneCase
	 * @return
	 */
	boolean editOneCase(Case oneCase, String chargeName);
}