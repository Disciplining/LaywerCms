package com.hyg.controller.criminalLawServer;

import com.hyg.pojo.ChargeType;
import com.hyg.service.ChargeTypeService;
import com.hyg.shiro.PermissionPrefix;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	/**
	 * 罪名分类表分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/charTypePageData")
	@ResponseBody
	public RespondJson<ChargeType> charTypePageData
	(
		@RequestParam(value = "page", defaultValue = "1") int pageNum,
		@RequestParam(value = "limit", defaultValue = "10") int pageSize
	)
	{
		return chargeTypeService.charTypePageData(pageNum, pageSize);
	}
}