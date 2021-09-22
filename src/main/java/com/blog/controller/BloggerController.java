package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 博主登陆相关
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

    @RequestMapping("/login")
    public String login(){
        return null;
    }
}
