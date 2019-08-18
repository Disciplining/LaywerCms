package com.hyg.util.respond;

import lombok.Data;

import java.util.List;

/**
 * 案例表添加时
 * 罪名分类 与 罪名名称
 * 的联动数据 单个对象
 */
@Data
public class CaseLinkageData
{
	private String chargeTypeName;

	private List<String> chargeNames;
}