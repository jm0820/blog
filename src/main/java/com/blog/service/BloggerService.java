package com.blog.service;

import com.blog.entity.Blogger;
import org.apache.ibatis.annotations.Param;

public interface BloggerService {
    public Blogger getByUserName(String userName);
}
