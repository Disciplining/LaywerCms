package com.hyg.controller.table;

import com.hyg.pojo.Agency;
import com.hyg.service.AgencyService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AgencyController
{
	@Autowired
	@Qualifier("agencyServiceImpl")
	private AgencyService agencyService;

	/**
	 * 获得事务所表中的所有数据
	 * @return
	 */
	@GetMapping("/getAgencyData")
	@ResponseBody
	public RespondJson<Agency> getAgencyData()
	{
		return agencyService.getAgencyData();
	}
}