package com.blog.realm;

import com.blog.entity.Blogger;
import com.blog.service.BloggerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {
    @Resource
    private BloggerService bloggerService;

    /**
     * 获取授权信息的
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登陆验证
     * @param authenticationToken 基于用户名密码的令牌
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 从令牌中取出用户名
        String userName = (String)authenticationToken.getPrincipal();
        // 让shiro 去验证账号密码
        Blogger blogger = bloggerService.getByUserName(userName);
        if(blogger != null){
            SecurityUtils.getSubject().getSession().setAttribute("currentUser",blogger);
            SimpleAuthenticationInfo authenInfo  = new SimpleAuthenticationInfo(blogger.getUserName(), blogger.getPassword(), getName());
            return authenInfo;
        }
        return null;
    }

}
