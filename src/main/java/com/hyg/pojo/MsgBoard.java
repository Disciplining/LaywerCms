package com.hyg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 留言表
 */
@Data
public class MsgBoard
{
	private Integer msgId;
	private String customerName;
	private String customerTel;
	private String caseDetail;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Timestamp createDate;
	private Integer replyId;
	private String replyName;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Timestamp replyDate;
	private String readFlag;
	private String replyMsg;
}