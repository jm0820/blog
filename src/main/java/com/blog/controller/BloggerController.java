package com.blog.controller;

import com.blog.com.blog.util.CyptographyUtil;
import com.blog.entity.Blogger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 博主登陆相关
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

    @RequestMapping("/login")
    public String login(Blogger blogger, HttpServletRequest request){
        String userName = blogger.getUserName();
        String password = blogger.getPassword();
        String pw= CyptographyUtil.md5(password,"java1234");
        /**Subject*/
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,pw);
        try {
            //传递token 给shiro 的realm
            subject.login(token);
            return "redirect:/admin/main.jsp";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("出错了");
            request.setAttribute("blogger",blogger);
            request.setAttribute("errorInfo","用户名或者密码错误");
        }
        return "login";
    }
}
