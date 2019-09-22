package com.st.springstore.common.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringShiroConfig {

	@Bean
	public SecurityManager securityManager(
			@Autowired Realm realm) {
		DefaultWebSecurityManager sManager=
				new DefaultWebSecurityManager();
		sManager.setRealm(realm);//把realm传递给安全管理器
		sManager.setSessionManager( newSessionManager());
		return sManager;
	}
	@Bean("shiroFilterFactory")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(
			@Autowired SecurityManager securityManager) {
		ShiroFilterFactoryBean sfBean=
				new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(securityManager);
		//假如没有认证请求先访问登录的url
		sfBean.setLoginUrl("/user/login");
		//定义map指定请求过滤规则(哪些资源允许匿名访问,哪些必须认证访问)
		LinkedHashMap<String,String> map=
				new LinkedHashMap<>();
		//静态资源允许匿名访问:"anon"

		map.put("/plugins/**","anon");
		//		 map.put("/user/login", "authc");
		//除了匿名访问的资源,其它都要认证("authc")后访问
		//		 map.put("/**","authc");
		sfBean.setFilterChainDefinitionMap(map);
		return sfBean;
	}
	//配置会话管理器
	public DefaultWebSessionManager newSessionManager() {
		DefaultWebSessionManager sManager=
				new DefaultWebSessionManager();
		sManager.setGlobalSessionTimeout(60*60*1000);//将会话时长设置为60分钟
		return sManager;
	}
}
