package com.elead.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elead.dao.SmbmsBillMapper;
import com.elead.pojo.SmbmsBill;
import com.elead.service.BillService;
import com.github.pagehelper.PageInfo;
@Service
public class BillServiceImpl implements BillService{
    @Autowired
    private SmbmsBillMapper smbmsbillmapper;
    @Override
    public PageInfo<SmbmsBill> getAllBill(SmbmsBill bill) {
        // TODO Auto-generated method stub
        List<SmbmsBill> allBill = smbmsbillmapper.getAllBill(bill);
        PageInfo<SmbmsBill> pageInfo = new PageInfo<SmbmsBill>(allBill);
        return pageInfo;
    }

  

}
