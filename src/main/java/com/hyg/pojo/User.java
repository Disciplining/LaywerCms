package com.hyg.pojo;

import lombok.Data;

/**
 * 登录用户表
 */
@Data
public class User
{
	private Integer id;
	private String password;
	private String loginName;
	private String realName;
	private Boolean gender;
	private String userTel;
	private String email;
}