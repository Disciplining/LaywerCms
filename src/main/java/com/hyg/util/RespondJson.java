package com.hyg.util;

import lombok.Data;

import java.util.List;

@Data
public class RespondJson<T>
{
	private Integer code;
	private String msg;
	private Integer count;
	private List<T> data;

	public RespondJson() {}

	public RespondJson(Integer code, String msg, Integer count, List<T> data)
	{
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
}