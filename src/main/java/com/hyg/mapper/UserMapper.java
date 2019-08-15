package com.hyg.mapper;

import com.hyg.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("userMapper")
public interface UserMapper
{
	/**
	 * 根据id获得一个普通管理员用户
	 * @param id
	 * @return
	 */
	@Select(" select * from `t_user` where `deleteFlag`!='1' and locate('root_user',`role`)=0 and `id`=#{id} ")
	User getOneUserById(int id);

	/**
	 * 向用户表中插入一条数据
	 * @param user
	 */
	@Insert("insert into `t_user` (`password`,`loginName`,`realName`,`gender`,`userTel`,`email`,`deleteFlag`,`role`,`position`) " +
				"values (#{password},#{loginName},#{realName},#{gender},#{userTel},#{email},#{deleteFlag},#{role},#{position})")
	void insertOneUser(User user);

	/**
	 * 用户登录会调用这个语句
	 * 根据用户名查找一个用户
	 * @param loginName
	 * @return
	 */
	@Select(" select * from `t_user` where `loginName`=#{loginName} and `deleteFlag`!='1' ")
	User getOneUserByName(String loginName);

	/**
	 * 根据id删除一个普通管理用户（逻辑删除）
	 * @param id
	 */
	@Update(" update `t_user` set `deleteFlag`='1' where `id`=#{id} and locate('root_user',`role`)=0 ")
	void deleteOneUserById(int id);

	/**
	 * 编辑一个普通管员用户
	 * @param user
	 */
	@Update(" update `t_user` set " +
				" `loginName`=#{loginName},`realName`=#{realName},`gender`=#{gender},`userTel`=#{userTel},`email`=#{email},`position`=#{position} " +
				" where `id`=#{id} and `deleteFlag`='0' and locate('root_user',`role`)=0 ")
	void updateOneUserById(User user);

	/**
	 * 根据用户名查询用户
	 * 模糊搜索
	 * @param name
	 * @return
	 */
	@Select(" select * from `t_user` where `loginName` like concat('%',#{name},'%') and `deleteFlag`='0' and locate('root_user',`role`)=0 ")
	List<User> listUsersByLoginName(String name);
}