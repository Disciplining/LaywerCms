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
}