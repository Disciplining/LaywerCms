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

import java.util.List;

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

	/**
	 * 根据id获得一个罪名类型
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/getOneChargeTypeById")
	@ResponseBody
	public RespondJson<ChargeType> getOneChargeTypeById(@RequestParam("id") int id)
	{
		return chargeTypeService.getOneChargeTypeById(id);
	}

	/**
	 * 编辑一个罪名类型
	 * 前端需要传过来的数据：id、chargeTypeName
	 * @param chargeType
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.UPDATE_DATA + "/editChargeType")
	public String editChargeType(ChargeType chargeType, Model model)
	{
		if (chargeTypeService.editChargeType(chargeType))
		{
			return "base/classificationMgr";
		}
		else
		{
			model.addAttribute("msg", "更新数据失败");
			return "base/editclassificationMgr";
		}
	}

	/**
	 * 根据id删除一个罪名类型
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.DELETE_DATA + "/deleteOneChargeType")
	@ResponseBody
	public boolean deleteOneChargeType(@RequestParam("id") int id)
	{
		return chargeTypeService.deleteOneChargeType(id);
	}

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