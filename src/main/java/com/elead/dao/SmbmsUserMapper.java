package com.elead.dao;


import java.util.List;

import com.elead.pojo.SmbmsUser;
public interface SmbmsUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmbmsUser record);

    int insertSelective(SmbmsUser record);

    SmbmsUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmbmsUser record);

    int updateByPrimaryKey(SmbmsUser record);
    
    SmbmsUser loginInfo(SmbmsUser user);
    
    List<SmbmsUser>getAllUser(SmbmsUser user);//分页
   
}