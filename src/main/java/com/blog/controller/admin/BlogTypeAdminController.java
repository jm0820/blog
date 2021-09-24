package com.blog.controller.admin;

import com.blog.com.blog.util.ResponseUtil;
import com.blog.entity.BlogType;
import com.blog.entity.PageBean;
import com.blog.service.BlogTypeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * 博客类型管理
 */
@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {

    @Resource
    private BlogTypeService blogTypeService;
    /**
     * 博客类型列表
     * @return
     */
    @RequestMapping({"/list"})
    public String list(@RequestParam(value="page",required = false)String page,
                       @RequestParam(value="rows",required = false)String rows,
                        HttpServletResponse response) throws IOException {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        HashMap<String,Object> hashMap = new HashMap<String,Object>();
        hashMap.put("start",pageBean.getStart());
        hashMap.put("size",pageBean.getPageSize());
        //查询博客类型列表
        List<BlogType> list = blogTypeService.list(hashMap);
        //查询总共有多少条数据
        Long total = blogTypeService.getTotal(hashMap);
        //将数据写入response
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);

        result.put("rows",jsonArray);
        result.put("total",total);
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     * 保存博客类别信息
     * @return
     */
    @RequestMapping({"/save"})
    public String save(BlogType blogType,
                       HttpServletResponse response) throws IOException {
        int resultTotal = 0;
        if(blogType.getId() == null){
            //添加
            resultTotal = blogTypeService.add(blogType).intValue();
        }else{
            //更新
            resultTotal = blogTypeService.update(blogType).intValue();
        }

        JSONObject result = new JSONObject();
        if(resultTotal > 0){
            result.put("success",Boolean.valueOf(true));
        }else {
            result.put("success",Boolean.valueOf(false));
        }
        ResponseUtil.write(response,result);
        return null;
    }

    @RequestMapping({"/delete"})
    public String delete(@RequestParam("ids") String ids,
                         HttpServletResponse response) throws IOException {
        String[] idsStr = ids.split(",");
        JSONObject result = new JSONObject();
        for(int i = 0;i < idsStr.length;i++){
            blogTypeService.delete(Integer.valueOf(idsStr[i]));
        }
        result.put("success",Boolean.valueOf(true));
        ResponseUtil.write(response,result);
        return null;
    }
}