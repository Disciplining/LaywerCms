package com.hyg.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class UserUtil
{
	/**
	 * 加密用户密码
	 * 接收用户密码明文 返回对应密文
	 * @param password
	 * @return
	 */
	public static String getEncryptPassword(String password)
	{
		// 不使用加盐加密
		String encryptionPassword = new Md5Hash(password,"",3).toString();

		return encryptionPassword;
	}
}