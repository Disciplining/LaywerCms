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
	 * 根据 客户姓名 和 案例描述 查找全部留言
	 * @param map name detail
	 * @return
	 */
	@Select(" select * from `t_msgBoard` " +
				" where `customerName` like concat('%',#{name},'%') and `caseDetail` like concat('%',#{detail},'%') ")
	List<MsgBoard> listAllMsgByNameAndDetail(Map map);

	/**
	 * 根据 客户姓名 和 案例描述 查找未读留言
	 * @param map
	 * @return
	 */
	@Select(" select * from `t_msgBoard` " +
			" where `customerName` like concat('%',#{name},'%') and `caseDetail` like concat('%',#{detail},'%') " +
				" and `readFlag`='0' ")
	List<MsgBoard> listNoReadMsgByNameAndDetail(Map map);

	/**
	 * 根据id删除一条留言
	 * @param id
	 */
	@Delete(" delete from `t_msgBoard` where `msgId`=#{id} ")
	void deleteOneMsgById(int id);

	/**
	 * 根据id获得一条留言
	 * @param id
	 * @return
	 */
	@Select(" select * from `t_msgBoard` where `msgId`=#{id} ")
	MsgBoard getOneMsgById(int id);
}