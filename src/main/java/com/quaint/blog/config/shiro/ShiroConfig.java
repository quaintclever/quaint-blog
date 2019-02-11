package com.quaint.blog.config.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 配置类
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /**
         * Shiro 内置过滤器  权限相关拦截器
         *      anon：无需认证（登陆），可直接访问
         *      authc： 必须认证才可以访问
         *      user： 如果使用remeberMe的功能才可以访问
         *      perms： 该资源必须得到资源权限才可以访问
         *      role： 该资源必须得到角色权限才可以访问
         */
        //创建map为资源添加相应权限
        Map<String,String> filterMap = new LinkedHashMap<>();
        //前台页面全部放行
        filterMap.put("/*","anon");
        //后台登陆界面放行
        filterMap.put("/quaint/login","anon");
        filterMap.put("/quaint/toLogin","anon");
        //后台页面全部拦截,测试时请注掉该拦截，或者改为单星 不拦截内部功能
        filterMap.put("/quaint/**","authc");

        //设置登陆失败跳转login页面
        shiroFilterFactoryBean.setLoginUrl("/quaint/toLogin");
        //设置授权
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }
    /**
     * 创建DefaultWebSecurityManager
     * @param userRealm
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * 创建UserRealm
     * @return
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

}
