package com.hyg.service.impl;

import com.github.pagehelper.PageHelper;
import com.hyg.mapper.MsgBoardMapper;
import com.hyg.pojo.MsgBoard;
import com.hyg.service.MsgBoardService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
			length = msgBoardMapper.listAllMsgByNameAndDetail(map);
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
}