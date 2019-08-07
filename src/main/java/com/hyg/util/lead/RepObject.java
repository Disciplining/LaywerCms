package com.hyg.util.lead;

import lombok.Data;

import java.util.List;

/**
 * 要返回给前端的对象
 */
@Data
public class RepObject
{
	private List<LawyerRep> data;
}
