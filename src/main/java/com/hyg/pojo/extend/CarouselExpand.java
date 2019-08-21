package com.hyg.pojo.extend;

import com.hyg.pojo.Carousel;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CarouselExpand extends Carousel
{
//	private Integer id;
//	private String bannerName;
//	private String imgPath;
//	private Date editDate;
	private MultipartFile file; // 图片
}