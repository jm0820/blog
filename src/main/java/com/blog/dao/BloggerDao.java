package com.blog.dao;

import com.blog.entity.Blogger;
import org.apache.ibatis.annotations.Param;

/**
 * 博主dao
 *
 */
public interface BloggerDao {
    public Blogger getByUserName(@Param("userName")String paramString);

}
