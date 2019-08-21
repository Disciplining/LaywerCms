package com.hyg.service.impl;

import com.github.pagehelper.PageHelper;
import com.hyg.config.PicDir;
import com.hyg.mapper.LawyerMapper;
import com.hyg.pojo.Lawyer;
import com.hyg.pojo.extend.LawyerExpand;
import com.hyg.service.LawyerService;
import com.hyg.util.FileUtil;
import com.hyg.util.respond.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		String lawyerPicDir = allPicDir + PicDir.LAWYER_DIR; // 存储律师照片的目录
		String picUrl = FileUtil.savePicToDisk(lawyerExpand.getFile(), lawyerPicDir, PicDir.LAWYER_DIR);
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
			System.out.println("debug--------------------------出现异常");
			return false;
		}

		return true;
	}

	/**
	 * 根据id删除一个律师
	 *
	 * @param lawyerId
	 * @return
	 */
	@Override
	public boolean deleteOneLawyerById(int lawyerId)
	{
		try
		{
			lawyerMapper.deleteOneLawyerById(lawyerId);
		}
		catch (Exception e)
		{
			return false;
		}

		return true;
	}

	/**
	 * 编辑一个律师的信息
	 *
	 * @param lawyerExpand 前端传过来的律师信息
	 * @return
	 */
	@Override
	@Transactional
	public boolean editOneLawyer(LawyerExpand lawyerExpand)
	{
		Lawyer lawyer = new Lawyer();
		lawyer.setLawyerId(lawyerExpand.getLawyerId());
		lawyer.setLawyerName(lawyerExpand.getLawyerName());
		lawyer.setLawyerLevel(lawyerExpand.getLawyerLevel());
		lawyer.setIntroduction(lawyerExpand.getIntroduction());

		if (lawyerExpand.getFile().getOriginalFilename().isEmpty() || lawyerExpand.getFile() == null) // 用户没选新的图片
		{
			Lawyer oldLawyer = lawyerMapper.getOneLawyerById(lawyer.getLawyerId());
			lawyer.setLawyerImg(oldLawyer.getLawyerImg()); // 还是设置原来的url
		}
		else // 用户选择了新的图片
		{
			// 存入新的图片
			String allPicDir = picDirSetting.substring(picDirSetting.indexOf(':')+1); //存储图片的总目录
			String lawyerPicDir = allPicDir + PicDir.LAWYER_DIR; // 存储律师照片的目录
			String picUrl = FileUtil.savePicToDisk(lawyerExpand.getFile(), lawyerPicDir, PicDir.LAWYER_DIR); // 将图片存入磁盘
			if (picUrl == null) // 为null说明存入磁盘失败
			{
				return false;
			}
			else
			{
				lawyer.setLawyerImg(picUrl); // 设置新的图片地址
			}

			// 删除磁盘中原先的图片
			String oldUrl = lawyerMapper.getOneLawyerById(lawyer.getLawyerId()).getLawyerImg();
			String allPicDirNext = oldUrl.substring(8);
			File oldPic = new File(allPicDir + allPicDirNext);

			if (oldPic.exists())
			{
				oldPic.delete();
			}
		}

		// 更新数据
		try
		{
			lawyerMapper.updateOneLawyerBiId(lawyer);
		}
		catch (Exception e)
		{
			return false;
		}

		return true;
	}

	/**
	 * 根据律师名和律师职称查找律师
	 *
	 * @param lawyerName
	 * @param lawyerLevel
	 * @return
	 */
	@Override
	public RespondJson<Lawyer> listPageData(int pageNum, int pageSize, String lawyerName, String lawyerLevel)
	{
		Map<String, String> par =  new HashMap<>(2);

		par.put("lawyerName", lawyerName);
		par.put("lawyerLevel", lawyerLevel);

		List<Lawyer> length = lawyerMapper.listLawyersByNameAndLevel(par); // 获取开启分页前的长度

		PageHelper.startPage(pageNum, pageSize);
		List<Lawyer> lawyers = lawyerMapper.listLawyersByNameAndLevel(par);

		RespondJson<Lawyer> json = new RespondJson<>();
		json.setCode(0);
		json.setMsg("");
		json.setCount(length.size());
		json.setData(lawyers);

		return json;
	}

	/**
	 * 根据id获得一个个律师
	 *
	 * @param id
	 * @return
	 */
	@Override
	public RespondJson<Lawyer> getOneLawyerById(int id)
	{
		Lawyer lawyer = lawyerMapper.getOneLawyerById(id);

		List<Lawyer> list = new ArrayList<>(1);
		list.add(lawyer);

		RespondJson<Lawyer> json = new RespondJson<>();
		json.setCode(0);
		json.setCount(1);
		json.setMsg("");
		json.setData(list);

		return json;
	}
}