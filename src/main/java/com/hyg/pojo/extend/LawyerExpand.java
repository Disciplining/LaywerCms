package com.hyg.pojo.extend;

import com.hyg.pojo.Lawyer;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class LawyerExpand extends Lawyer
{
//	private Integer lawyerId;
//	private String lawyerName;
//	private String lawyerLevel;
//	private String introduction;
//	private String lawyerImg;
//	private String deleteFlag;
	private MultipartFile file;
}