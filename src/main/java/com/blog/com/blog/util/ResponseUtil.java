package com.blog.com.blog.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 写入response 的工具类
 */
public class ResponseUtil {
    public static void write(HttpServletResponse response,Object o) throws IOException {
        response.setContentType("text/html;charser=utf-8");
        PrintWriter out = response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
}
