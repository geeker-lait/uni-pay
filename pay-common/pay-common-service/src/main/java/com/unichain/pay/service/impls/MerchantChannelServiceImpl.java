package com.unichain.pay.service.impls;

import com.unichain.pay.dao.MerchantChannelMapper;
import com.unichain.pay.pojo.query.CompanyChannelQuery;
import com.unichain.pay.service.MerchantChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantChannelServiceImpl implements MerchantChannelService {
    @Autowired
    private MerchantChannelMapper merchantChannelMapper;

    @Override
    public MerchantChannelMapper getCrudRepository() {
        return merchantChannelMapper;
    }

    public CompanyChannelQuery createQuery() {
        return null;
    }
}
