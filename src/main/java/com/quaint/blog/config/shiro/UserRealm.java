package com.quaint.blog.config.shiro;

import com.quaint.blog.pojo.Users;
import com.quaint.blog.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义授权认证方法
 * quaint
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    /**
     * 用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权开始");
        return null;
    }

    /**
     * 用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证开始！");
        //编写shiro 判断的逻辑
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //1.判断用户名
        Users user = userService.selectByName(token.getUsername());
        if(user==null){
            //用户名不存在，返回null 会抛出UnknownAccountException异常
            return null;
        }
        //2.判断密码
        return new SimpleAuthenticationInfo("",user.getUserPwd(),"");
    }
}
