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

}