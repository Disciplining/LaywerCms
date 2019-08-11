package com.hyg.service.impl;

import com.hyg.config.PicDir;
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

import java.util.List;

@Service("lawyerServiceImpl")
public class LawyerServiceImpl implements LawyerService
{
	@Autowired
	@Qualifier("lawyerMapper")
	private LawyerMapper lawyerMapper;

	// 存储图片总目录
	// 显示图片的url为： /images/这个目录下路径
	// 例如这个目录是：/pic-dir/  下边有一张图片：/pic-dir/aa/bb/test.png
	// 那么显示的路径就是：/images/aa/bb/test.png
	@Value("${cbs.imagesPath}")
	private String picDirSetting; //全局配置文件中设置的图片的路径

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
		String allPicDir = picDirSetting.substring(picDirSetting.indexOf(':')+1); //存储图片的总目录
		String lawyerPicDir = allPicDir + PicDir.LAWYER_TABLE_DIR; // 存储律师照片的目录
		String picUrl = FileUtil.savePicToDisk(lawyerExpand.getLawyerImgExpand(), lawyerPicDir);
		if (picUrl == null)
		{
			return false;
		}
		else
		{
			lawyer.setLawyerImg(picUrl);
		}

		// 除前端传过来的数据剩下的字段
		lawyer.setDeleteFlag("0");

		// 存入数据库
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