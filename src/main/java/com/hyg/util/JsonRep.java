package com.hyg.util;

import lombok.Data;

import java.util.List;

/**
 * 返回的json数据对应的类
 * @param <T>
 */
@Data
public class JsonRep<T>
{
	private List<T> data;
}