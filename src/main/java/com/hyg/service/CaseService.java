package com.hyg.service;

import com.hyg.pojo.Case;
import com.hyg.pojo.CaseExpand;
import com.hyg.util.respond.CaseLinkageData;
import com.hyg.util.respond.RespondJson;
import org.springframework.web.multipart.MultipartFile;

/**
 * 案例表
 */
public interface CaseService
{
	/**
	 * 获得添加案例时的联动数据
	 * @return
	 */
	RespondJson<CaseLinkageData> getLinkageDate();

	/**
	 * 添加一个案例
	 * 前端传过来的数据：
	 * chargeName   罪名名称 根据这个获得 chargeId
	 * file			图片文件 根据这人获得picUrl
	 *
	 * title        案例标题
	 * desc         案例介绍
	 * process      办案过程
	 * result	    结果
	 * lessions	    经验心得
	 * successFlag  是否成功
	 *
	 * 后端需要的数据：chargeId、title*、desc*、process*、result*、lessions*、publishDate、successFlag*、editDate、count、deleteFlag、picUrl
	 *
	 * @param onCase
	 * @return
	 */
	boolean insertOneCase(Case onCase, String chargeName, MultipartFile file);

	/**
	 * 分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	RespondJson<Case> pageDate(int pageNum, int pageSize);

	/**
	 * 根据id获得一个案例
	 * @param id
	 * @return
	 */
	RespondJson<CaseExpand> getOneCaseById(int id);

	/**
	 * 根据id删除一个案例
	 * @param id
	 * @return
	 */
	boolean deleteOneCaseById(int id);

	/**
	 * 编辑一个案例
	 * 前端传过来的数据：chargeName file(可能有也可能没有)， id title desc process result lessions successFlag
	 * 后端需要的数据： id* chargeId title* desc* process* result* lessions* successFlag* editDate picUrl
	 * @param oneCase
	 * @param chargeName
	 * @param file
	 * @return
	 */
	boolean editOneCase(Case oneCase, String chargeName, MultipartFile file);
}