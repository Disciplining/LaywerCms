package com.hyg.controller.criminalLawServer;

import com.hyg.service.ChargeTypeService;
import com.hyg.shiro.PermissionPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 罪名表控制器
 */
@Controller
public class ChargeController
{
	@Autowired
	@Qualifier("chargeTypeServiceImpl")
	private ChargeTypeService chargeTypeService;

	/**
	 * 获得所有的罪名分类名称
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/listChargeTypeName")
	@ResponseBody
	public List<String> listChargeTypeName()
	{
		return chargeTypeService.listChargeTypeName();
	}
}