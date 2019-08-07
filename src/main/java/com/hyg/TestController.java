package com.hyg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController
{
	@GetMapping("/")
	public String index()
	{
		return "views/index";
	}

	@GetMapping("/test")
	@ResponseBody
	public String test(String testName)
	{
		return "成功:" + testName;
	}

	@GetMapping("/testJson")
	@ResponseBody
	public Resp foo()
	{
		Ariticle ariticle = new Ariticle();
		ariticle.setArticleId(1);
		ariticle.setArticleTitle("名字1");
		ariticle.setAuthor("作者1");
		ariticle.setIntro("简介1");
		ariticle.setContent("内容1");
		ariticle.setEditDate(new Date(System.currentTimeMillis()));
		ariticle.setCount(10);

		List<Ariticle> list = new ArrayList<>();

		list.add(ariticle);

		Resp resp = new Resp();

		resp.setCode("0");
		resp.setData(list);

		return resp;
	}
}

class Resp
{
	private String code;
	private List<Ariticle> data;

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public List<Ariticle> getData()
	{
		return data;
	}

	public void setData(List<Ariticle> data)
	{
		this.data = data;
	}
}