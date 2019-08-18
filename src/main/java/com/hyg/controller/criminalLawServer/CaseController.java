package com.hyg.controller.criminalLawServer;

import com.hyg.service.CaseService;
import com.hyg.shiro.PermissionPrefix;
import com.hyg.util.respond.CaseLinkageData;
import com.hyg.util.respond.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CaseController
{
	@Autowired
	@Qualifier("caseServiceImpl")
	private CaseService caseService;

	/**
	 * 获得添加案例时的联动数据
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/getLinkageDate")
	@ResponseBody
	public RespondJson<CaseLinkageData> getLinkageDate()
	{
		return caseService.getLinkageDate();
	}
}