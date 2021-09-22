package com.blog.controller;

import com.blog.entity.Blogger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 博主登陆相关
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

    @RequestMapping("/login")
    public String login(Blogger blogger){
        return null;
    }
}
