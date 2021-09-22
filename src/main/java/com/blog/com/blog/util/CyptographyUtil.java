package com.blog.com.blog.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * md5加密
 */
public class CyptographyUtil {

    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString();
    }

    public static void main(String[] args) {
        String str = md5("123456", "java1234");
        System.out.println(str);
    }
}
