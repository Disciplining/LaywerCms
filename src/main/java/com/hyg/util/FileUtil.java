package com.hyg.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件工具类
 */
public class FileUtil
{
	/**
	 * 获得文件扩展名 包括"."
	 * @param fileName 文件的原名
	 * @return 例如 ".jpg"、".png"、""
	 */
	public static String getFileExtension(final String fileName)
	{
		int dotIndex = fileName.lastIndexOf('.');
		
		if (dotIndex == -1) // 没有扩展名
		{
			return "";
		}
		else // 有扩展名
		{
			return fileName.substring(dotIndex);
		}
	}

	/**
	 * 将用户上传的图片存入磁盘
	 * 并返回显示图片的url
	 * @param multipartFile 图片（图片数据）
	 * @param picDir 图片的存储目录 绝对路径
	 * @param nextDir 图片存储总目录下级目录
	 * @return 显示图片的url 存入失败返回 null
	 */
	public static String savePicToDisk(MultipartFile multipartFile, String picDir, String nextDir)
	{
		String fileName = UUID.randomUUID().toString(); // 文件名
		String fileExtension = FileUtil.getFileExtension(multipartFile.getOriginalFilename()); // 文件扩展名

		// 如果图片存储的目录不存在先创建目录
		File parentDir = new File(picDir);
		if(!parentDir.exists())
		{
			parentDir.mkdirs();
		}

		try
		{
			multipartFile.transferTo( new File(picDir + fileName + fileExtension) ); // 存入磁盘
		}
		catch (IOException e) // 存入磁盘失败
		{
			e.printStackTrace();
			return null;
		}

		return "/images/" + nextDir + fileName + fileExtension;
	}
}