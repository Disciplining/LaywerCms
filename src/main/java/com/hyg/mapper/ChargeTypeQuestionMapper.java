package com.hyg.mapper;

import com.hyg.pojo.ChargeTypeQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 罪名分类问答表 mapper
 */
@Mapper
@Repository("chargeTypeQuestionMapper")
public interface ChargeTypeQuestionMapper
{
	/**
	 * 插入一条数据
	 * @param question
	 */
	@Insert(" insert into `t_chargeTypeQuestion` (`chargeTypeId`,`question`,`answer`,`editDate`,`count`,`deleteFlag`) " +
				" values (#{chargeTypeId},#{question},#{answer},#{editDate},#{count},#{deleteFlag}) ")
	void insertOneChargeTypeQuestion(ChargeTypeQuestion question);

	/**
	 * 获得所有的数据
	 * @return
	 */
	@Select(" select * from `t_chargeTypeQuestion` where `deleteFlag`!='1' ")
	List<ChargeTypeQuestion> listAllQuestion();
}