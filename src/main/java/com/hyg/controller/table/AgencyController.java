package com.hyg.controller.table;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyg.pojo.Agency;
import com.hyg.service.AgencyService;
import com.hyg.shiro.PermissionPrefix;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AgencyController
{
	@Autowired
	@Qualifier("agencyServiceImpl")
	private AgencyService agencyService;

	private static final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 获得事务所表中的所有数据
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/getAgencyData")
	@ResponseBody
	public RespondJson<Agency> getAgencyData()
	{
		return agencyService.getAgencyData();
	}

	/**
	 * 更新律师事务所介绍
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.UPDATE_DATA + "/agencyDetail")
	public String updateAgencyDetail(String content, Model model)
	{
		System.out.println(content);

		if (agencyService.updateAgencyDetail(content))
		{
			model.addAttribute("res", "更新数据成功");
			return "base/introuceMgr";
		}
		else
		{
			model.addAttribute("res", "更新数据失败");
			return "base/introuceMgr";
		}
	}
}