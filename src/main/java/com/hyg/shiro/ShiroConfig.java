package com.hyg.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig
{
	/**
	 * 这个方法关联一个安全管理器
	 * @param defaultWebSecurityManager
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager defaultWebSecurityManager)
	{
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager); //关联安全管理器

		/**
		 * 设置拦截URL
		 */
//		Map<String, String> map = new LinkedHashMap<>();
//		map.put("/add", "authc"); //拦截的URL中可以使用*号
//		map.put("/update", "authc");
//		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

		/**
		 * 设置未认证时发给controller的请求
		 */
		shiroFilterFactoryBean.setLoginUrl("/");

		return  shiroFilterFactoryBean;
	}

	/**
	 * 获得一个安全管理器
	 * 这个方法关联一个realm类
	 * @param userRealm
	 * @return
	 */
	@Bean(name = "manager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("realm") UserRealm userRealm)
	{
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(userRealm); //设置realm

		return manager;
	}

	/**
	 * 获得一个realm类
	 * @return
	 */
	@Bean(name = "realm")
	public UserRealm getRealm()
	{
		return new UserRealm();
	}
}