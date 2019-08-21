package com.hyg.mapper;

import com.hyg.pojo.ChargeTypeQuestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 罪名分类问答表 mapper
 */
@Mapper
@Repository("chargeTypeQuestionMapper")
public interface ChargeTypeQuestionMapper
{
	/*增*/
	/**
	 * 插入一条数据
	 * @param question
	 */
	@Insert(" insert into `t_chargeTypeQuestion` (`chargeTypeId`,`question`,`answer`,`editDate`,`count`,`deleteFlag`) " +
				" values (#{chargeTypeId},#{question},#{answer},#{editDate},#{count},#{deleteFlag}) ")
	void insertOneChargeTypeQuestion(ChargeTypeQuestion question);
	/*---------------------------------------------------------------------------------------------------------------*/

	/*删*/
	/**
	 * 根据id删除一条数据
	 * @param id
	 */
	@Update(" update `t_chargeTypeQuestion` set `deleteFlag`='1' where `id`=#{id} ")
	void deleteOneQuestionById(int id);
	/*---------------------------------------------------------------------------------------------------------------*/

	/*改*/
	/**
	 * 编辑一个问答
	 *  更新字段：question、answer、editDate
	 * @param question
	 */
	@Update(" update `t_chargeTypeQuestion` set `question`=#{question},`answer`=#{answer},`editDate`=#{editDate} " +
			" where `id`=#{id} and `deleteFlag`!='1' ")
	void updateEditOneQuestion(ChargeTypeQuestion question);
	/*---------------------------------------------------------------------------------------------------------------*/

	/*查*/
	/**
	 * 获得所有的数据
	 * @return
	 */
	@Select(" select * from `t_chargeTypeQuestion` where `deleteFlag`!='1' ")
	List<ChargeTypeQuestion> listAllQuestion();

	/**
	 * 根据id获得一条数据
	 * @param id
	 * @return
	 */
	@Select(" select * from `t_chargeTypeQuestion` where `id`=#{id} and `deleteFlag`!='1' ")
	ChargeTypeQuestion getOneQuestionById(int id);
	/*------------------------------------------------------------------------*/
}