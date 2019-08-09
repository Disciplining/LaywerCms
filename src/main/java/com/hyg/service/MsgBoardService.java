package com.hyg.service;

import com.hyg.pojo.MsgBoard;
import com.hyg.util.RespondJson;

public interface MsgBoardService
{
	/**
	 * 获得留言表 json数据 对应的对象
	 * @return
	 */
	RespondJson<MsgBoard> getMsgBoardData();
}