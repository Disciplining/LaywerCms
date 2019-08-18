package com.hyg.mapper;

import com.hyg.pojo.Case;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("caseMapper")
public interface CaseMapper
{
	/**
	 * 添加一个案例
	 * @param oneCase
	 */
	@Insert(" insert into `t_case` (`chargeId`,`title`,`desc`,`process`,`result`,`lessions`,`publishDate`,`successFlag`,`editDate`,`count`,`deleteFlag`) " +
				" values (#{chargeId},#{title},#{desc},#{process},#{result},#{lessions},#{publishDate},#{successFlag},#{editDate},#{count},#{deleteFlag}) ")
	void insertOneDate(Case oneCase);

	/**
	 * 查询所有数据
	 * @return
	 */
	@Select(" select * from `t_case` where `deleteFlag`!='1' ")
	List<Case> listAllCase();
}