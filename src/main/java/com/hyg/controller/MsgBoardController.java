package com.hyg.controller;

import com.hyg.pojo.MsgBoard;
import com.hyg.service.MsgBoardService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MsgBoardController
{
	@Autowired
	@Qualifier("msgBoardServiceImpl")
	private MsgBoardService msgBoardService;

	@GetMapping("/getMsgBoardData")
	@ResponseBody
	public RespondJson<MsgBoard> getMsgBoardData()
	{
		return msgBoardService.getMsgBoardData();
	}
}