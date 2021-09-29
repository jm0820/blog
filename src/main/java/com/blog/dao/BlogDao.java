package com.blog.dao;
import  com.blog.entity.Blog;

import java.util.List;
import java.util.Map;

public interface BlogDao {
    /**无参数查询博客列表*/
    public List<Blog> countList();

    /**根据Id查询一条博客类型*/
    public Blog findById(Integer id);

    /**根据不固定参数查询博客列表*/
    public List<Blog> list(Map<String, Object> paramMap);

    /**根据不固定参数查询博客数量*/
    public Long getTotal(Map<String, Object> paramMap);

    /**添加一条博客*/
    public Integer add(Blog blog);

    /**修改一条博客*/
    public Integer update(Blog blogType);

    /**删除一条博客*/
    public Integer delete(Integer id);
}
