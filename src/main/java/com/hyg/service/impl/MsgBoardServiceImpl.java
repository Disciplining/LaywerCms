package com.hyg.service.impl;

import com.github.pagehelper.PageHelper;
import com.hyg.mapper.LawyerMapper;
import com.hyg.mapper.MsgBoardMapper;
import com.hyg.pojo.Lawyer;
import com.hyg.pojo.MsgBoard;
import com.hyg.service.MsgBoardService;
import com.hyg.util.respond.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
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
	 * 分页数据
	 * @param name
	 * @return
	 */
	@Override
	public RespondJson<MsgBoard> listPageData(int type, int pageNum, int pageSize, String name, String detail)
	{
		Map<String, String> map = new HashMap<>(2);
		map.put("name", name);
		map.put("detail", detail);

		List<MsgBoard> length;
		List<MsgBoard> msgBoards;

		if (type == 0) // 全部
		{
			length = msgBoardMapper.listAllMsgByNameAndDetail(map);
			PageHelper.startPage(pageNum, pageSize);
			msgBoards = msgBoardMapper.listAllMsgByNameAndDetail(map);
		}
		else if (type == 1) // 未读
		{
			length = msgBoardMapper.listNoReadMsgByNameAndDetail(map);
			PageHelper.startPage(pageNum, pageSize);
			msgBoards = msgBoardMapper.listNoReadMsgByNameAndDetail(map);
		}
		else
		{
			length = new ArrayList<>(0);
			msgBoards = new ArrayList<>(0);
		}

		RespondJson<MsgBoard> json = new RespondJson<>();
		json.setCode(0);
		json.setMsg(null);
		json.setCount(length.size());
		json.setData(msgBoards);

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
	 * 根据id获得一条留言
	 *
	 * @param id
	 * @return
	 */
	@Override
	public RespondJson<MsgBoard> getOneMsgById(int id)
	{
		RespondJson<MsgBoard> json = new RespondJson<>();
		json.setCount(0);
		json.setMsg(null);

		MsgBoard msgBoard = msgBoardMapper.getOneMsgById(id);
		if (msgBoard != null)
		{
			List<MsgBoard> list = new ArrayList<>(1);
			list.add(msgBoard);

			json.setData(list);
			json.setCount(list.size());
		}
		else
		{
			json.setData(null);
			json.setCount(0);
		}

		return json;
	}

	/**
	 * 回复留言
	 * 前端传过来的字段：masId、replyId、replyMsg
	 * 需要更新的字段：replyId、replyName、replyDate、replyFlag、replyMsg
	 * @param msgBoard
	 * @return
	 */
	@Override
	public boolean updateReplyMsg(MsgBoard msgBoard)
	{
		// 需要更新但前端没有传过来的数据
		Lawyer lawyer = lawyerMapper.getOneLawyerById(msgBoard.getReplyId());
		if (lawyer == null)
		{
			return false;
		}
		else
		{
			msgBoard.setReplyName(lawyer.getLawyerName());
		}
		msgBoard.setReplyDate(new Timestamp(System.currentTimeMillis()));
		msgBoard.setReadFlag("1");

		msgBoardMapper.updateReplyMsg(msgBoard);

		return true;
	}
}