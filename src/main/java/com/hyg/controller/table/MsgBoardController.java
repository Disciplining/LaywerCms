package com.hyg.controller.table;

import com.hyg.pojo.MsgBoard;
import com.hyg.service.MsgBoardService;
import com.hyg.shiro.PermissionPrefix;
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
	 * 分页数据
	 * @param name
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/msgBoardPageData")
	@ResponseBody
	public RespondJson<MsgBoard> msgBoardPageData
	(
		@RequestParam(value = "flag", defaultValue = "0") int type, // 0表示全部 1表示未读
		@RequestParam(value = "page", defaultValue = "1") int pageNum, // 页码
		@RequestParam(value = "limit", defaultValue = "10") int pageSize, // 每页的条数
		@RequestParam(value = "name", defaultValue = "") String name, // 客户姓名
		@RequestParam(value = "detail", defaultValue = "") String detail // 案情描述
	)
	{
		return msgBoardService.listPageData(type, pageNum, pageSize, name, detail);
	}

	/**
	 * 删除留言
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.DELETE_DATA + "/deleteOneMsgById")
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