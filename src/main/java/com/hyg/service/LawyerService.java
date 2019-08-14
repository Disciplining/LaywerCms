package com.hyg.service;

import com.hyg.pojo.Lawyer;
import com.hyg.pojo.LawyerExpand;
import com.hyg.util.RespondJson;

public interface LawyerService
{
	/**
	 * 添加一个律师
	 * @param lawyerExpand
	 */
	boolean insertOneLawyer (LawyerExpand lawyerExpand);

	/**
	 * 根据id删除一个律师
	 * @param lawyerId
	 * @return
	 */
	boolean deleteOneLawyerById(int lawyerId);

	/**
	 * 编辑一个律师的信息
	 * @param lawyerExpand 前端传过来的律师信息
	 * @return
	 */
	boolean editOneLawyer(LawyerExpand lawyerExpand);

	/**
	 * 根据律师名和律师职称查找律师
	 * @param lawyerName
	 * @param lawyerLevel
	 * @return
	 */
	RespondJson<Lawyer> listPageData(int pageNum, int pageSize, String lawyerName, String lawyerLevel);
}