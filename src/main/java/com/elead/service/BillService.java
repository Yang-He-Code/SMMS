package com.elead.service;

import com.elead.pojo.SmbmsBill;
import com.github.pagehelper.PageInfo;

public interface BillService {
    PageInfo<SmbmsBill>getAllBill(SmbmsBill bill);
}
