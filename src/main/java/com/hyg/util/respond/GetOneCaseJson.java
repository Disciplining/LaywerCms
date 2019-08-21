package com.hyg.util.respond;

import com.hyg.pojo.extend.CaseExpand;
import lombok.Data;

import java.util.List;

/**
 * 获得一个案例时返回的json格式
 * 即包含 案例数据 又包含联动数据
 */
@Data
public class GetOneCaseJson
{
	Integer code;

	List<CaseLinkageData> linkageDate;

	List<CaseExpand> data;

	public GetOneCaseJson(Integer code, List<CaseLinkageData> linkageDate, List<CaseExpand> data)
	{
		this.code = code;
		this.linkageDate = linkageDate;
		this.data = data;
	}
}