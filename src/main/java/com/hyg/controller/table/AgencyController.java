package com.hyg.controller.table;

import com.hyg.config.PicDir;
import com.hyg.pojo.Agency;
import com.hyg.service.AgencyService;
import com.hyg.util.FileUtil;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AgencyController
{
	@Autowired
	@Qualifier("agencyServiceImpl")
	private AgencyService agencyService;

	@Value("${cbs.imagesPath}")
	private String picDirSetting; //全局配置文件中设置的图片的路径

	/**
	 * 获得事务所表中的所有数据
	 * @return
	 */
	@GetMapping("/selectData/getAgencyData")
	@ResponseBody
	public RespondJson<Agency> getAgencyData()
	{
		return agencyService.getAgencyData();
	}

	/**
	 * 更新律师事务所介绍
	 * @return
	 */
	@PostMapping("/updateData/agencyDetail")
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

	/**
	 * 事务所详情的图片
	 * @param file
	 * @return
	 */
	@PostMapping("/insertData/uploadAgencyDetailPic")
	@ResponseBody
	public Map<String,String> uploadAgencyDetailPic(@RequestBody MultipartFile file)
	{
		String allPicDir = picDirSetting.substring(picDirSetting.indexOf(':')+1); //存储图片的总目录
		String detailPicDir = allPicDir + PicDir.AGENCY_DETAIL_DIR; // 存储事务所详情的图片的目录
		String picUrl = FileUtil.savePicToDisk(file, detailPicDir, PicDir.AGENCY_DETAIL_DIR);

		Map<String, String> map = new HashMap<>(2);
		map.put("uploadResult", picUrl==null ? "fail" : "success");
		map.put("picUrl", picUrl);

		return map;
	}
}