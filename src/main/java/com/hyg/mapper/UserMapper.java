package com.hyg.mapper;

import com.hyg.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("userMapper")
public interface UserMapper
{
	@Insert("insert into `t_user` (`password`,`loginName`,`realName`,`gender`,`userTel`,`email`) values (#{password},#{loginName},#{realName},#{gender},#{userTel},#{email})")
	void insertOneUser(User user);

	@Select("select * from `t_user` where `loginName`=#{loginName}")
	User getOneUser(String loginName);
}