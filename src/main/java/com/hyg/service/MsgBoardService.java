package com.hyg.service;

import com.hyg.pojo.MsgBoard;
import com.hyg.util.RespondJson;

public interface MsgBoardService
{
	/**
	 * 分页数据
	 * @param name
	 * @return
	 */
	RespondJson<MsgBoard> listPageData(int type, int pageNum, int pageSize, String name, String detail);

	/**
	 * 根据id删除一条留言
	 * @param id
	 * @return
	 */
	boolean deleteOneMsgById(int id);
}