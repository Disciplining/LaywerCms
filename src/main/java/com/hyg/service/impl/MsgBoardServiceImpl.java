package com.hyg.service.impl;

import com.hyg.mapper.LawyerMapper;
import com.hyg.mapper.MsgBoardMapper;
import com.hyg.pojo.Lawyer;
import com.hyg.pojo.MsgBoard;
import com.hyg.service.MsgBoardService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("msgBoardServiceImpl")
public class MsgBoardServiceImpl implements MsgBoardService
{
	@Autowired
	@Qualifier("msgBoardMapper")
	private MsgBoardMapper msgBoardMapper;

	@Autowired
	@Qualifier("lawyerMapper")
	private LawyerMapper lawyerMapper;

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

	/**
	 * 返回未读的数据
	 *
	 * @return
	 */
	@Override
	public RespondJson<MsgBoard> listMsgNoRead()
	{
		List<MsgBoard> list = msgBoardMapper.listMsgNoRead();

		System.out.println(list);

		RespondJson<MsgBoard> json = new RespondJson<>();
		json.setCode(0);
		json.setMsg(null);
		json.setCount(list.size());
		json.setData(list);

		return json;
	}

	/**
	 * 根据客户姓名查 和案情描述 查找留言
	 * @param name
	 * @return
	 */
	@Override
	public RespondJson<MsgBoard> listMsgByNameAndDetail(String name, String detail)
	{
		Map<String, String> map = new HashMap<>(2);
		map.put("name", name);
		map.put("detail", detail);

		List<MsgBoard> list = msgBoardMapper.listMsgByNameAndDetail(map);

		RespondJson<MsgBoard> json = new RespondJson<>();
		json.setCode(0);
		json.setMsg(null);
		json.setCount(list.size());
		json.setData(list);

		return json;
	}

	/**
	 * 根据id删除一条留言
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteOneMsgById(int id)
	{
		try
		{
			msgBoardMapper.deleteOneMsgById(id);
		}
		catch (Exception e)
		{
			System.out.println("+++++++++++出现了异常++++++++++++");
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * 回复留言
	 * 前端传过来的数据有：msgId、replyId、replyMsg
	 *
	 * @param msgBoard
	 * @return
	 */
	@Override
	public boolean updateReplyMsg(MsgBoard msgBoard)
	{
		Lawyer lawyer = lawyerMapper.getOneLawyerById(msgBoard.getReplyId()); // 根据前端传过来的工号查找律师

		if (lawyer == null)
		{
			return false;
		}

		msgBoard.setReplyName(lawyer.getLawyerName());
		msgBoard.setReplyDate(new Timestamp(System.currentTimeMillis()));
		msgBoard.setReadFlag("1");

		return true;
	}
}