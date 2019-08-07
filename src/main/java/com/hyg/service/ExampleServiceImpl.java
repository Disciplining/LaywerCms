package com.hyg.service;

import com.hyg.util.ExampleRep;
import com.hyg.util.JsonRep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleServiceImpl")
public class ExampleServiceImpl implements ExampleService
{
	/**
	 * 获取案例数据
	 *
	 * @return
	 */
	@Override
	public JsonRep<ExampleRep> getExampleData()
	{
		/**
		 * 模拟数据库数据
		 */
		List<ExampleRep> list = new ArrayList<>();
		for (int i =1; i <= 50; i++)
		{
			ExampleRep temp = new ExampleRep();
			temp.setTitle("夫妻离婚，子女的抚养费如何确定？" + i);
			temp.setDesc("离婚法》中对父母《离婚法》中对父母《离婚法父母《离婚法》中对父母《离婚法》中对》中对父母 《离婚法》中对父母《离婚法》中对父母《离婚法》中对父母《离婚法》中对父母");
			temp.setSort("案例分类");
			temp.setColor("子女抚养");
			temp.setImg("http://xxxx");
			list.add(temp);
		}

		JsonRep<ExampleRep> jsonRep = new JsonRep<>();
		jsonRep.setData(list);

		return jsonRep;
	}
}