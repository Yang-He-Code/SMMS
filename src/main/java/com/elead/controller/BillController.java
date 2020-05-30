package com.elead.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elead.pojo.SmbmsBill;
import com.elead.service.BillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Controller
@RequestMapping("/jsp")
public class BillController {

    @Autowired
    private BillService billService;

    @RequestMapping("/getBillList")
    @ResponseBody
    public Map<String, Object> getBillList(Integer pageNum, Integer pageSize, SmbmsBill bill) {
        System.out.println(pageNum+"=================");
        System.out.println(pageSize+"=================");
        System.out.println(bill.toString()+"=================");
        // 开始分页
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<SmbmsBill> allBill = billService.getAllBill(bill);
        // 新建一个map集合用于存储数据
        Map<String, Object> map = new HashMap<String, Object>();
        // 总条数
        map.put("total", allBill.getTotal());
        // 结果集
        map.put("rows", allBill.getList());
        // 当前页
        map.put("pageNum", allBill.getPageNum());
        // 每页的数量
        map.put("pageSize", allBill.getPageSize());
        // 当前页的数量
        map.put("size", allBill.getSize());
        // 总页数
        map.put("pages", allBill.getPages());
        // 所有导航页号
        map.put("navigatepageNums", allBill.getNavigatepageNums());
        // 是否为首页
        map.put("isIsFirstPage", allBill.isIsFirstPage());
        // 最后一页
        map.put("isIsLastPage", allBill.isIsLastPage());
        System.out.println("开始遍历商品");
        System.err.println("订单管理后台信息："+map);
        return map;

    }
}
