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
	 * 获得所有的登录用户
	 * @return
	 */
	@Select("select * from `t_user`")
	public List<User> listUsers();

	@Insert("insert into `t_user` (`password`,`loginName`,`realName`,`gender`,`userTel`,`email`) values (#{password},#{loginName},#{realName},#{gender},#{userTel},#{email})")
	void insertOneUser(User user);
}