package com.elead.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elead.pojo.SmbmsUser;
import com.elead.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/jsp")
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping("/getUser")
    public Map<String, Object> getBillList(Integer pageNum, Integer pageSize, SmbmsUser user) {
        System.out.println(pageNum+"=================");
        System.out.println(pageSize+"=================");
        System.out.println(user.toString()+"=================");
        // 开始分页
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<SmbmsUser> allUser = userService.getAllUser(user);
        // 新建一个map集合用于存储数据
        Map<String, Object> map = new HashMap<String, Object>();
        // 总条数
        map.put("total", allUser.getTotal());
        // 结果集
        map.put("rows", allUser.getList());
        // 当前页
        map.put("pageNum", allUser.getPageNum());
        // 每页的数量
        map.put("pageSize", allUser.getPageSize());
        // 当前页的数量
        map.put("size", allUser.getSize());
        // 总页数
        map.put("pages", allUser.getPages());
        // 所有导航页号
        map.put("navigatepageNums", allUser.getNavigatepageNums());
        // 是否为首页
        map.put("isIsFirstPage", allUser.isIsFirstPage());
        // 最后一页
        map.put("isIsLastPage", allUser.isIsLastPage());
        System.out.println("开始遍历商品");
        System.err.println("订单管理后台信息："+map);
        return map;

    }
    
}
