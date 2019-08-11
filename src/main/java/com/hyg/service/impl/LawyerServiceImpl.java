package com.hyg.service.impl;

import com.hyg.mapper.LawyerMapper;
import com.hyg.pojo.Lawyer;
import com.hyg.pojo.LawyerExpand;
import com.hyg.service.LawyerService;
import com.hyg.util.FileUtil;
import com.hyg.util.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service("lawyerServiceImpl")
public class LawyerServiceImpl implements LawyerService
{
	@Autowired
	@Qualifier("lawyerMapper")
	private LawyerMapper lawyerMapper;

	@Value("${cbs.imagesPath}")
	private String picDir; //全局配置文件中设置的图片的路径

	/**
	 * 获得符合前端格式的
	 * 留言表的数据
	 *
	 * @return
	 */
	@Override
	public RespondJson<Lawyer> getLawyerData()
	{
		List<Lawyer> list = lawyerMapper.listLawyers();

		RespondJson<Lawyer> json = new RespondJson<>();

		json.setCode(0);
		json.setMsg(null);
		json.setCount(list.size());
		json.setData(list);

		return json;
	}

	/**
	 * 添加一个律师
	 *
	 * @param lawyerExpand 前端传过来的律师数据，包含图片
	 */
	@Override
	public boolean insertOneLawyer(LawyerExpand lawyerExpand)
	{
		Lawyer lawyer = new Lawyer();

		// 前端传过来的数据
		lawyer.setLawyerName(lawyerExpand.getLawyerName());
		lawyer.setLawyerLevel(lawyerExpand.getLawyerLevel());
		lawyer.setIntroduction(lawyerExpand.getIntroduction());

		String parentDirPath = picDir.substring(picDir.indexOf(':')+1); //通过设置的那个字符串获得存放图片的目录路径
		String fileName = UUID.randomUUID().toString(); // 文件名
		String fileExtension = FileUtil.getFileExtension(lawyerExpand.getLawyerImgExpand().getOriginalFilename()); // 文件扩展名

		File parentDir = new File(parentDirPath);
		if(!parentDir.exists()) //如果图片目录不存在先创建目录
		{
			parentDir.mkdirs();
		}

		try
		{
			lawyerExpand.getLawyerImgExpand().transferTo( new File(parentDirPath + fileName + fileExtension) ); // 存入磁盘
		}
		catch (IOException e)
		{
			// 存入磁盘失败
			e.printStackTrace();
			return false;
		}

		lawyer.setLawyerImg("/images/" + fileName + fileExtension);

		// 除前端传过来的数据剩下的字段
		lawyer.setDeleteFlag("0");

		try
		{
			lawyerMapper.insertOneLawyer(lawyer);
		}
		catch (Exception e)
		{
			return false;
		}

		return true;
	}
}