package com.hyg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestCon
{
	@GetMapping("/test")
	@ResponseBody
	public Map<String, Integer> testFun()
	{
		Map<String, Integer> map = new HashMap<>();

		map.put("a",1);
		map.put("b",2);

		return map;
	}
}