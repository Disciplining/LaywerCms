package com.hyg.controller.table;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyg.pojo.Agency;
import com.hyg.service.AgencyService;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class AgencyController
{
	@Autowired
	@Qualifier("agencyServiceImpl")
	private AgencyService agencyService;

	@Value("${cbs.imagesPath}")
	private String picDirSetting; //全局配置文件中设置的图片的路径

	private static final ObjectMapper objectMapper = new ObjectMapper();
	private PrintWriter writer = null;

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
	public void file_upload
	(
		@RequestParam(value = "imgFile", required = false) MultipartFile file,
		HttpServletRequest request,
		HttpServletResponse response,
		HttpSession session
	) throws IOException
	{
		// 输出用  否则上传完不能关闭掉页面  展现图片
		// 老师你可以注释掉关于writer的行
		// 就能体会到我说的意思了 哈哈哈
		writer = response.getWriter();

		if (!file.isEmpty())
		{
			System.out.println(file.getOriginalFilename()); // 获取到文件的原名 例如 XXX.jpg
			String originalFilename = file.getOriginalFilename(); // 获取到后缀

			String[] exts = originalFilename.split("\\.");
			String ext = exts[exts.length - 1];

			ServletContext application = request.getSession().getServletContext();
			// 路径为/upload
			String savePath = application.getRealPath("/") + "/upload/";
			// 文件保存目录URL
			String saveUrl = request.getContextPath() + "/upload/";
			// 检查目录（不存在就添加）
			File uploadDir = new File(savePath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			if (!uploadDir.isDirectory()) {
				writer.println(objectMapper.writeValueAsString("上传目录不存在。"));
				return;
			}
			// 检查目录写权限
			if (!uploadDir.canWrite()) {
				writer.println(objectMapper.writeValueAsString("上传目录没有写权限。"));
				return;
			}
			String dirName = request.getParameter("dir");
			if (dirName == null) {
				dirName = "image";
			}
			// 路径为/upload/image
			savePath += dirName + "/";
			saveUrl += dirName + "/";
			File saveDirFile = new File(savePath);
			if (!saveDirFile.exists()) {
				saveDirFile.mkdirs();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String ymd = sdf.format(new Date());
			savePath += ymd + "/";
			saveUrl += ymd + "/";
			// 路径为/upload/image/20181207
			File dirFile = new File(savePath);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			String fileName = sdf.format(new Date()) + new Random().nextInt(1000) + "." + ext;
			String filePath = savePath + fileName;
			File fileFile = new File(filePath);
			// 路径为/YucaiAdmin/target/YucaiAdmin/upload/image/20181207/20181207879.png
			try
			{
				// 生成文件
				file.transferTo(fileFile);
				// 生成文件成功
				// 然后设置返回
				// 这里有个问题  就是如果不设置下面的语句  会出现文件已经保存完毕  但是页面不会直接跳转
				// 会直接出现上传错误
				Map<String, Object> msg = new HashMap<String, Object>();
				msg.put("error", 0);
				msg.put("url", saveUrl + fileName);
				writer.println(objectMapper.writeValueAsString(msg));
			} catch (IOException e) {
				writer.println(objectMapper.writeValueAsString("上传文件失败。") + e.getMessage());
				e.printStackTrace();
			}
			return;
		}
	}
}