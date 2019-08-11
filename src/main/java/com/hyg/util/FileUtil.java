package com.hyg.util;

/**
 * 文件工具类
 */
public class FileUtil
{
	/**
	 * 获得文件扩展名
	 * @param fileName 文件的原名
	 * @return
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
}