package com.elead.service;

import com.elead.pojo.SmbmsProvider;
import com.github.pagehelper.PageInfo;

public interface ProviderService {
    PageInfo<SmbmsProvider> getProvider(SmbmsProvider provider);
}
