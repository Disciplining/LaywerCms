package com.hyg.mapper;

import com.hyg.pojo.Agency;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service("agencyMapper")
public interface AgencyMapper
{
	/**
	 * 事务所表  只有一条数据
	 * @return
	 */
	@Select("select * from `t_agency` where `deleteFlag`!='1'")
	List<Agency> listAgency();

}