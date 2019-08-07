package com.hyg.pojo;

import lombok.Data;

/**
 * 菜单表
 */
@Data
public class Menu
{
	private Integer menuId;
	private String muneName;
	private Integer parentId;
	private String router;
}