package com.hyg.service.impl;

import com.hyg.mapper.MsgBoardMapper;
import com.hyg.pojo.MsgBoard;
import com.hyg.service.MsgBoardService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class MsgBoardServiceImpl implements MsgBoardService
{
	@Autowired
	@Qualifier("msgBoardMapper")
	private MsgBoardMapper msgBoardMapper;

	/**
	 * 获得符合前端格式的
	 * 留言表的数据
	 *
	 * @return
	 */
	@Override
	public RespondJson<MsgBoard> getMsgBoardData()
	{
		List<MsgBoard> list = msgBoardMapper.listMsgBoards();

		RespondJson<MsgBoard> json = new RespondJson<>();
		json.setCode(0);
		json.setMsg("");
		json.setCount(list.size());
		json.setData(list);

		return json;
	}
}