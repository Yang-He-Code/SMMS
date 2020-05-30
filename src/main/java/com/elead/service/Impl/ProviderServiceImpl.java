package com.elead.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elead.dao.SmbmsProviderMapper;
import com.elead.pojo.SmbmsProvider;
import com.elead.service.ProviderService;
import com.github.pagehelper.PageInfo;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private SmbmsProviderMapper smbmsProviderMapper;
    @Override
    public PageInfo<SmbmsProvider> getProvider(SmbmsProvider provider) {
        // TODO Auto-generated method stub
        List<SmbmsProvider> providers = smbmsProviderMapper.getProviders(provider);
        PageInfo<SmbmsProvider> pageInfo = new PageInfo<SmbmsProvider>(providers);
        return pageInfo;
    }

}
