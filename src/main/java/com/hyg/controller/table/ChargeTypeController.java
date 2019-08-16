package com.hyg.controller.table;

import com.hyg.pojo.ChargeType;
import com.hyg.service.ChargeTypeService;
import com.hyg.shiro.PermissionPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 罪名分类表控制器
 */
@Controller
public class ChargeTypeController
{
	@Autowired
	@Qualifier("chargeTypeServiceImpl")
	private ChargeTypeService chargeTypeService;

	/**
	 * 添加一个罪名分类
	 * 前端传来的数据：chargeTypeName
	 * @param chargeType
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.INSERT_DATA + "/insertOneChargeType")
	@ResponseBody
	public String insertOneChargeType(ChargeType chargeType, Model model)
	{
		if (chargeTypeService.insertOneChargeType(chargeType))
		{
			return "base/classificationMgr";
		}
		else
		{
			model.addAttribute("msg", "添加罪名分类失败，请检查罪名是否已存在");
			return "base/addclassificationMgr";
		}
	}
}