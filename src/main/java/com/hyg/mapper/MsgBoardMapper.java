package com.hyg.mapper;

import com.hyg.pojo.MsgBoard;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
@Service("msgBoardMapper")
public interface MsgBoardMapper
{
	/**
	 * 根据 客户姓名 和 案例描述 查找留言
	 * @param map name detail
	 * @return
	 */
	@Select(" select * from `t_msgBoard` " +
				" where `customerName` like concat('%',#{name},'%') and `caseDetail` like concat('%',#{detail},'%') ")
	List<MsgBoard> listMsgByNameAndDetail(Map map);

	/**
	 * 根据id删除一条留言
	 * @param id
	 */
	@Delete(" delete from `t_msgBoard` where `msgId`=#{id} ")
	void deleteOneMsgById(int id);
}