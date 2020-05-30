package com.elead.service;

import com.elead.pojo.SmbmsUser;
import com.github.pagehelper.PageInfo;


public interface UserService {

     SmbmsUser loginInfo(SmbmsUser user);
     
     PageInfo<SmbmsUser> getAllUser(SmbmsUser user);
}
