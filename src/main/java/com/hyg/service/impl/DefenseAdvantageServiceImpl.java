package com.hyg.service.impl;

import com.hyg.config.PicDir;
import com.hyg.mapper.DefenseAdvantageMapper;
import com.hyg.pojo.DefenseAdvantage;
import com.hyg.pojo.DefenseAdvantageExpand;
import com.hyg.service.DefenseAdvantageService;
import com.hyg.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

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
		String iconUrl = FileUtil.savePicToDisk(advantageExpand.getFile(), picDirSetting.substring(picDirSetting.indexOf(':')+1)+PicDir.DEFENSE_ADVANTAGE, PicDir.DEFENSE_ADVANTAGE);

		if (iconUrl == null)
		{
			return false;
		}

		DefenseAdvantage advantage = new DefenseAdvantage();
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
}