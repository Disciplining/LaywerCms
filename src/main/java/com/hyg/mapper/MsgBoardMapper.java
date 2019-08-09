package com.hyg.mapper;

import com.hyg.pojo.MsgBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("msgBoardMapper")
public interface MsgBoardMapper
{
	/**
	 * 获得 留言表 中的所有数据的所有信息
	 * @return
	 */
	@Select("select * from `t_msgBoard`")
	List<MsgBoard> listMsgBoards();
}