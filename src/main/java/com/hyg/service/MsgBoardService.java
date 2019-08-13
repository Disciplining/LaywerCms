package com.hyg.service;

import com.hyg.pojo.MsgBoard;
import com.hyg.util.RespondJson;

public interface MsgBoardService
{
	/**
	 * 获得符合前端格式的
	 * 留言表的数据
	 * @return
	 */
	RespondJson<MsgBoard> getMsgBoardData();

	/**
	 * 返回未读的数据
	 * @return
	 */
	RespondJson<MsgBoard> listMsgNoRead();

	/**
	 * 根据客户姓名查 和案情描述 查找留言
	 * @param name
	 * @return
	 */
	RespondJson<MsgBoard> listMsgByNameAndDetail(String name, String detail);
}