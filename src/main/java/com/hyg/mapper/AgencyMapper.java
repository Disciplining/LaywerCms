package com.hyg.mapper;

import com.hyg.pojo.Agency;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * t_agency 表中只有一条数据
 */
@Mapper
@Repository("agencyMapper")
public interface AgencyMapper
{
	@Select("select * from `t_agency`")
	Agency getAgency();
}