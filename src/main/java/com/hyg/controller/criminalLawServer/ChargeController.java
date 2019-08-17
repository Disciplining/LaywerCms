package com.hyg.controller.criminalLawServer;

import com.hyg.pojo.Charge;
import com.hyg.service.ChargeService;
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
 * 罪名表控制器
 */
@Controller
public class ChargeController
{
	@Autowired
	@Qualifier("chargeTypeServiceImpl")
	private ChargeTypeService chargeTypeService;

	@Autowired
	@Qualifier("chargeServiceImpl")
	private ChargeService chargeService;

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

	/**
	 * 添加一个罪名
	 * 前端传过来的数据：chargeTypeName    chargeName、lawContent、sentenceRange、defense
	 * @param charge
	 * @param chargeTypeName
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.INSERT_DATA + "/insertOneCharge")
	public String insertOneCharge(Charge charge, String chargeTypeName, Model model)
	{
		if (chargeService.insertOneCharge(charge, chargeTypeName))
		{
			return "base/chargeMgr";
		}
		else
		{
			model.addAttribute("msg", "添加数据失败");
			return "base/addCharge";
		}
	}

	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/chargePageData")
	@ResponseBody
	public RespondJson<Charge> chargePageData
	(
		@RequestParam(value = "page", defaultValue = "1") int pageNum,
		@RequestParam(value = "limit", defaultValue = "10") int pageSize,
		@RequestParam(value = "chargeName", defaultValue = "") String chargeName
	)
	{
		return chargeService.chargePageData(pageNum, pageSize, chargeName);
	}

	/**
	 * 根据id删除一个罪名
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.DELETE_DATA + "/deleteOneChargeById")
	@ResponseBody
	public boolean deleteOneChargeById(@RequestParam("id") int id)
	{
		return chargeService.deleteOneChargeById(id);
	}

	/**
	 * 根据id获取一个罪名
	 * @param id
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/getOneChargeById")
	@ResponseBody
	public RespondJson<Charge> getOneChargeById(@RequestParam("id") int id)
	{
		return chargeService.getOneChargeById(id);
	}

	/**
	 * 编辑
	 * @param charge
	 * @return
	 */
	@PostMapping("/" + PermissionPrefix.UPDATE_DATA + "/editChargeById")
	public String editChargeById(Charge charge, Model model)
	{
		if (chargeService.updateEditChargeById(charge))
		{
			return "base/chargeMgr";
		}
		else
		{
			model.addAttribute("msg", "更新数据失败");
			return "base/editChargeMgr";
		}
	}
}