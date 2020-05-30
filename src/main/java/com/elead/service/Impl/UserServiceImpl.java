package com.elead.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elead.dao.SmbmsUserMapper;
import com.elead.pojo.SmbmsUser;
import com.elead.service.UserService;
import com.github.pagehelper.PageInfo;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SmbmsUserMapper smbmsUserMapper;
    @Override
    public SmbmsUser loginInfo(SmbmsUser user) {
        // TODO Auto-generated method stub
        return smbmsUserMapper.loginInfo(user);
    }
    @Override
    public PageInfo<SmbmsUser> getAllUser(SmbmsUser user) {
        // TODO Auto-generated method stub
        List<SmbmsUser> allUser = smbmsUserMapper.getAllUser(user);
        PageInfo<SmbmsUser> pageInfo = new PageInfo<SmbmsUser>(allUser);
        return pageInfo;
    }

    

}
