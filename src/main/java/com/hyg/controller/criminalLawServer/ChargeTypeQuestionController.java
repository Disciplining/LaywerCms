package com.hyg.controller.criminalLawServer;

import com.hyg.pojo.ChargeTypeQuestion;
import com.hyg.service.ChargeTypeQuestionService;
import com.hyg.shiro.PermissionPrefix;
import com.hyg.util.respond.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChargeTypeQuestionController
{
	@Autowired
	@Qualifier("chargeTypeQuestionServiceImpl")
	private ChargeTypeQuestionService service;

	/**
	 * 插入一条问答数据
	 * 前端传过来的数据：chargeTypeName  question、answer
	 * @param question
	 * @param chargeTypeName
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.INSERT_DATA + "/insertOneChargeTypeQuestion")
	public String insertOneChargeTypeQuestion(ChargeTypeQuestion question, String chargeTypeName, Model model)
	{
		if (service.insertOneChargeTypeQuestion(question, chargeTypeName))
		{
			return "base/answerLawMgr";
		}
		else
		{
			model.addAttribute("msg", "插入数据失败");
			return "base/addAnswerLawMgr";
		}
	}

	/**
	 * 分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/questionsPageData")
	@ResponseBody
	public RespondJson<ChargeTypeQuestion> questionsPageData
	(
		@RequestParam(value = "page", defaultValue = "1") int pageNum,
		@RequestParam(value = "limit", defaultValue = "10") int pageSize
	)
	{
		return service.pageData(pageNum, pageSize);
	}

	/**
	 * 根据id删除一个问答
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.DELETE_DATA + "/deleteOneQuestionById")
	@ResponseBody
	public boolean deleteOneQuestionById(@RequestParam("id") int id)
	{
		return service.deleteOneQuestionById(id);
	}

	/**
	 * 根据id获得一条数据
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/getOneQuestionById")
	@ResponseBody
	public RespondJson<ChargeTypeQuestion> getOneQuestionById(@RequestParam("id") int id)
	{
		return service.getOneQuestionById(id);
	}

	/**
	 * 编辑一个问答
	 * 前端传过来的数据：id、question、answer
	 * @param question
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.UPDATE_DATA + "/editOneQuestion")
	public String editOneQuestion(ChargeTypeQuestion question, Model model)
	{
		if (service.editOneQuestion(question))
		{
			return "base/answerLawMgr";
		}
		else
		{
			model.addAttribute("msg", "更新数据失败");
			return "base/editAnswerLawMgr";
		}
	}
}