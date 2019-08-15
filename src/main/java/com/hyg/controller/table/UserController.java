package com.hyg.controller.table;

import com.alibaba.fastjson.JSON;
import com.hyg.pojo.User;
import com.hyg.service.UserService;
import com.hyg.shiro.PermissionPrefix;
import com.hyg.util.RespondJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController
{
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	/**
	 * 用户添加接口 接口json数据
	 * 使用这个接口向数据库中添加用户 不提供前端页面
	 * 后期注释掉这个接口
	 * @param jsonData 用户数据包含明文密码
	 * @return
	 */
	@PostMapping("/userReg")
	@ResponseBody
	public boolean userReg(@RequestBody String jsonData)
	{
		User user = JSON.parseObject(jsonData, User.class);

		return userService.dealUserReg(user);
	}

	/**
	 * 普通管理员用户添加接口 接收表单数据
	 * 超级管理员才有权限添加用户
	 * 前端传过来的数据：密码、登录名、真实姓名、性别、手机、邮箱、职位
	 * @param user 用户数据包含明文密码
	 * @return
	 */
	@PostMapping("/root/addOneUser")
	public String addOneUser(User user, Model model)
	{
		if (userService.dealUserReg(user))
		{
			return "base/userMgr";
		}
		else
		{
			model.addAttribute("res", "添加用户失败");
			return "base/addUser";
		}
	}

	/**
	 * 用户登录接口
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping("/userLogin")
	public String userLogin(User user, Model model)
	{
		int flag = userService.dealUserLogin(user);

		if (flag == 0) // 用户不存在
		{
			model.addAttribute("res", "用户不存在");
			return "base/login";
		}
		else if (flag == 1) // 用户存在但密码错误
		{
			model.addAttribute("res", "密码错误");
			return "base/login";
		}
		else if (flag == 2) // 登录成功
		{
			// 获得登录用户
			Subject subject = SecurityUtils.getSubject();
			User loginUser = (User) subject.getPrincipal(); //需要强转

			model.addAttribute("loginName", loginUser.getLoginName());
			return "index";
		}
		else
		{
			model.addAttribute("res", "出现未知错误");
			return "base/login";
		}
	}

	/**
	 * 退出登录
	 * @return
	 */
	@GetMapping("/userLogout")
	public String userLogout()
	{
		SecurityUtils.getSubject().logout();
		return "base/login";
	}

	/**
	 * 删除一个普通管理员用户
	 * @param id
	 * @return
	 */
	@GetMapping("/root/deleteOneUserById")
	@ResponseBody
	public String deleteOneUserById(@RequestParam("id") String id)
	{
		if (userService.deleteOneUserById(Integer.parseInt(id)))
		{
			return "success";
		}
		else
		{
			return "fail";
		}
	}

	/**
	 * 编辑一个普通管理员用户
	 * 前端传过来的信息：用户id、登录名、真实姨名、姓别、电话、邮箱、职务
	 * @param user
	 * @return
	 */
	@PostMapping("/root/editOneUser")
	public String editOneUser(User user, Model model)
	{
		if (userService.updateOneUserById(user))
		{
			return "base/userMgr";
		}
		else
		{
			model.addAttribute("res", "编辑失败");
			return "base/editUser";
		}
	}

	/**
	 * 分页数据
	 * @param pageNum
	 * @param pageSize
	 * @param loginName
	 * @return
	 */
	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/userPageData")
	@ResponseBody
	public RespondJson<User> userPageData
	(
		@RequestParam(value = "page", defaultValue = "1") int pageNum,
		@RequestParam(value = "limit", defaultValue = "10") int pageSize,
		@RequestParam(value = "loginName", defaultValue = "") String loginName
	)
	{
		return userService.listPageData(pageNum, pageSize, loginName);
	}

	@GetMapping("/" + PermissionPrefix.SELECT_DATA + "/getOneUserById")
	@ResponseBody
	public RespondJson<User> getOneUserById(@RequestParam("id") int id)
	{
		return userService.getOneUserById(id);
	}
}