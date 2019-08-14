package com.hyg.controller;

import com.hyg.config.PicDir;
import com.hyg.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用控制器
 */
@Controller
public class CommonController
{
	@Value("${cbs.imagesPath}")
	private String picDirSetting; //全局配置文件中设置的图片的路径

	/**
	 * 设置首页
	 * @return
	 */
	@GetMapping("/")
	public String index()
	{
		return "base/login";
	}

	/**
	 * 富文本编辑器图片上传
	 * 参数名必须叫 imgFile (也可以用注解指定)
	 * 返回的json数据格式必须是这样
	 * 这是 kindereditor 规定的
	 * @param imgFile
	 * @return
	 */
	@PostMapping("/insertData/richTextPic")
	@ResponseBody
	public Map<String, Object> uploadAgencyDetailPic(MultipartFile imgFile)
	{
		System.out.println(imgFile);
		System.out.println(imgFile.getOriginalFilename());

		String savePath = picDirSetting.substring(picDirSetting.indexOf(':')+1) + PicDir.AGENCY_DETAIL_DIR; // 图片存储目录
		String saveUrl = FileUtil.savePicToDisk(imgFile, savePath, PicDir.AGENCY_DETAIL_DIR); // 将图片存入硬盘并返回显示用的url

		Map<String, Object> msg = new HashMap<>(); // 返回给前端的json数据

		if (saveUrl == null)
		{
			msg.put("error", 1);
			msg.put("url", null);
		}
		else
		{
			msg.put("error", 0);
			msg.put("url", saveUrl);
		}
		return msg;
	}
}