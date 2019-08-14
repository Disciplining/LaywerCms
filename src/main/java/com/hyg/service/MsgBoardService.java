package com.hyg.service;

import com.hyg.pojo.MsgBoard;
import com.hyg.util.RespondJson;

public interface MsgBoardService
{
	/**
	 * 根据客户姓名查 和案情描述 查找留言
	 * @param name
	 * @return
	 */
	RespondJson<MsgBoard> listMsgByNameAndDetail(String name, String detail);

	/**
	 * 根据id删除一条留言
	 * @param id
	 * @return
	 */
	boolean deleteOneMsgById(int id);
}