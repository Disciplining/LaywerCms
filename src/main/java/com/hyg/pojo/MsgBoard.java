package com.hyg.pojo;

import lombok.Data;

/**
 * 留言表
 */
@Data
public class MsgBoard
{
	private Integer msgId;
	private Integer customerName;
	private Integer customerTel;
	private Integer caseDetail;
	private Integer createDate;
	private Integer replyId;
	private Integer replyName;
	private Integer replyDate;
	private Boolean readFlag;
}