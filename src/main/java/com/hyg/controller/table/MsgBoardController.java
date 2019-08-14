package com.hyg.controller.table;

import com.hyg.pojo.MsgBoard;
import com.hyg.service.MsgBoardService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MsgBoardController
{
	@Autowired
	@Qualifier("msgBoardServiceImpl")
	private MsgBoardService msgBoardService;

	/*==============================================*/

	/**
	 * 根据 客户姓名 和 案例详情 查找留言
	 * @param name
	 * @return
	 */
	@GetMapping("/selectData/listMsgByNameAndDetail")
	@ResponseBody
	public RespondJson<MsgBoard> listMsgByNameAndDetail
	(
		@RequestParam(value = "name", defaultValue = "") String name,
		@RequestParam(value = "detail", defaultValue = "") String detail
	)
	{
		return msgBoardService.listMsgByNameAndDetail(name, detail);
	}

	/**
	 * 删除留言
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteData/deleteOneMsgById")
	@ResponseBody
	public String deleteOneMsgById(@RequestParam(value = "id") int id)
	{
		if (msgBoardService.deleteOneMsgById(id))
		{
			return "success";
		}
		else
		{
			return "fail";
		}
	}
}