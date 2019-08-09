package com.hyg.pojo;

import lombok.Data;
import java.sql.Date;

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
	private Date createDate;
	private Integer replyId;
	private String replyName;
	private Date replyDate;
	private String readFlag;
}