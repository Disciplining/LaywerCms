package com.hyg.mapper;

import com.hyg.pojo.Lawyer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service("lawyerMapper")
public interface LawyerMapper
{
	/**
	 * 律师表
	 * @return
	 */
	@Select("select * from `t_lawyer`")
	List<Lawyer> listLawyers();

	/**
	 * 向律师表中添加一条数据
	 * @param lawyer
	 */
	@Insert("insert into `t_lawyer` (`lawyerName`,`lawyerLevel`,`introduction`,`lawyerImg`,`deleteFlag`)" +
			"values (#{lawyerName},#{lawyerLevel},#{introduction},#{lawyerImg},#{deleteFlag});")
	void insertOneLawyer(Lawyer lawyer);
}