package com.hyg.mapper;

import com.hyg.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("userMapper")
public interface UserMapper
{
	/**
	 * 用户表
	 * @return
	 */
	@Select(" select * from `t_user` where `deleteFlag`!='1' ")
	List<User> listUsers();

	/**
	 * 向用户表中插入一条数据
	 * @param user
	 */
	@Insert("insert into `t_user` (`password`,`loginName`,`realName`,`gender`,`userTel`,`email`,`deleteFlag`) " +
				"values (#{password},#{loginName},#{realName},#{gender},#{userTel},#{email},#{deleteFlag})")
	void insertOneUser(User user);

	/**
	 * 根据用户名查找一个用户
	 * @param loginName
	 * @return
	 */
	@Select(" select * from `t_user` where `loginName`=#{loginName} and `deleteFlag`!='1' ")
	User getOneUser(String loginName);
}