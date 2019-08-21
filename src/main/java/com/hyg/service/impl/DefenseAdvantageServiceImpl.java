package com.hyg.service.impl;

import com.github.pagehelper.PageHelper;
import com.hyg.config.PicDir;
import com.hyg.mapper.DefenseAdvantageMapper;
import com.hyg.pojo.DefenseAdvantage;
import com.hyg.pojo.extend.DefenseAdvantageExpand;
import com.hyg.service.DefenseAdvantageService;
import com.hyg.util.FileUtil;
import com.hyg.util.respond.RespondJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service("defenseAdvantageServiceImpl")
public class DefenseAdvantageServiceImpl implements DefenseAdvantageService
{
	@Autowired
	@Qualifier("defenseAdvantageMapper")
	private DefenseAdvantageMapper mapper;

	@Value("${cbs.imagesPath}")
	private String picDirSetting; //全局配置文件中设置的图片的路径

	/**
	 * 添加一条数据
	 * 前端传过来的字段：title、content、file
	 * 后端需要的字段：title*、content*、icon、editDate、count、deleteFlag
	 * @param advantageExpand
	 * @return
	 */
	@Override
	public boolean insertOneAdvantage(DefenseAdvantageExpand advantageExpand)
	{
		DefenseAdvantage advantage = new DefenseAdvantage();

		advantage.setTitle(advantageExpand.getTitle());
		advantage.setContent(advantageExpand.getContent());

		String iconUrl = FileUtil.savePicToDisk(advantageExpand.getFile(), picDirSetting.substring(picDirSetting.indexOf(':')+1)+PicDir.DEFENSE_ADVANTAGE_DIR, PicDir.DEFENSE_ADVANTAGE_DIR);

		if (iconUrl == null)
		{
			return false;
		}

		advantage.setIcon(iconUrl);
		advantage.setEditDate(new Timestamp(System.currentTimeMillis()));
		advantage.setCount(0);
		advantage.setDeleteFlag("0");

		try
		{
			mapper.insertOneAdvantage(advantage);
		}
		catch (Exception e)
		{
			System.out.println("出现异常：" + e.getMessage());
			return false;
		}

		return true;
	}

	/**
	 * 编辑一条数据
	 * 前端传过来的数据：id、title、content、file
	 * 后端需要的数据：id*、title*、content*、editDate、icon
	 *
	 * @param expand
	 * @return
	 */
	@Override
	@Transactional
	public boolean editOneDefenseAdvantage(DefenseAdvantageExpand expand)
	{
		DefenseAdvantage advantage = new DefenseAdvantage();
		advantage.setId(expand.getId());
		advantage.setTitle(expand.getTitle());
		advantage.setContent(expand.getContent());
		advantage.setEditDate(new Timestamp(System.currentTimeMillis()));

		if (expand.getFile()==null || expand.getFile().getOriginalFilename().isEmpty()) // 用户没有选择新的图片
		{
			DefenseAdvantage oldAdvantage = mapper.getOneDefenseAdvantageById(expand.getId());
			advantage.setIcon(oldAdvantage.getIcon());
		}
		else // 用户选择了新的图片
		{
			String allPicDir = picDirSetting.substring(picDirSetting.indexOf(':')+1); //存储图片的总目录
			String iconUrl = FileUtil.savePicToDisk(expand.getFile(), allPicDir + PicDir.DEFENSE_ADVANTAGE_DIR, PicDir.DEFENSE_ADVANTAGE_DIR); // 存入新的图片
			if (iconUrl == null)
			{
				return false;
			}
			else
			{
				advantage.setIcon(iconUrl);
			}

			// 删除磁盘中原先的图片
			String oldIconUrl = mapper.getOneDefenseAdvantageById(expand.getId()).getIcon();
			String allPicDirNext = oldIconUrl.substring(8);
			File oldIcon = new File(allPicDir + allPicDirNext);

			if (oldIcon.exists())
			{
				oldIcon.delete();
			}
		}

		try
		{
			mapper.updateEditOneDefenseAdvantage(advantage);
		}
		catch (Exception e)
		{
			System.out.println("发生异常：" + e.getMessage());
			return false;
		}

		return true;
	}

	/**
	 * 分页数据
	 *
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public RespondJson<DefenseAdvantage> pageData(int pageNum, int pageSize)
	{
		List<DefenseAdvantage> list = mapper.listAllDefenseAdvantage(); // 分页前查询，为了长度

		PageHelper.startPage(pageNum, pageSize);
		List<DefenseAdvantage> advantages = mapper.listAllDefenseAdvantage();

		return new RespondJson<>(0, null, list.size(), advantages);
	}

	/**
	 * 根据id获得一条数据
	 *
	 * @param id
	 * @return
	 */
	@Override
	public RespondJson<DefenseAdvantage> getOneDefenseAdvantageById(int id)
	{
		DefenseAdvantage advantage = mapper.getOneDefenseAdvantageById(id);

		if (advantage != null)
		{
			List<DefenseAdvantage> list = new ArrayList<>(1);
			list.add(advantage);

			return new RespondJson<>(0, null, list.size(), list);
		}
		else
		{
			return new RespondJson<>(0, null, 0, new ArrayList<>(0));
		}
	}

	/**
	 * 根据id删除一条数据
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteOneDefenseAdvantageById(int id)
	{
		try
		{
			mapper.deleteOneDefenseAdvantageById(id);
		}
		catch (Exception e)
		{
			System.out.println("出现异常：" + e.getMessage());
			return false;
		}

		return true;
	}
}