package com.hyg.mapper;

import com.hyg.pojo.MsgBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service("msgBoardMapper")
public interface MsgBoardMapper
{
	/**
	 * 留言表
	 * @return
	 */
	@Select("select * from `t_msgBoard`")
	List<MsgBoard> listMsgBoards();

	/**
	 * 查询所有未读的留言
	 * @return
	 */
	@Select(" select * from `t_msgBoard` where `readFlag`='0' ")
	List<MsgBoard> listMsgNoRead();

	/**
	 * 根据客户姓名查找留言
	 * @param name
	 * @return
	 */
	@Select(" select * from `t_msgBoard` where `customerName` like concat(%,#{name},%) ")
	List<MsgBoard> listMsgByCustomerName(String name);
}