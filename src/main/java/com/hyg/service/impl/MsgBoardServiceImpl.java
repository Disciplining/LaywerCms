package com.hyg.service.impl;

import com.hyg.mapper.MsgBoardMapper;
import com.hyg.pojo.MsgBoard;
import com.hyg.service.MsgBoardService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
}