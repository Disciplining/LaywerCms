package com.hyg.service.impl;

import com.hyg.mapper.DeleteMapper;
import com.hyg.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 根据主键删除表中的数据
 */
@Service("deleteServiceImpl")
public class DeleteServiceImpl implements DeleteService
{
	@Autowired
	@Qualifier("deleteMapper")
	private DeleteMapper deleteMapper;

	/**
	 * 团队文集表
	 *
	 * @param id
	 */
	@Override
	public boolean deleteOneArticleById(int id)
	{
		try
		{
			deleteMapper.deleteOneArticleById(id);
		}
		catch (Exception e)
		{
			return false;
		}

		return true;
	}
}