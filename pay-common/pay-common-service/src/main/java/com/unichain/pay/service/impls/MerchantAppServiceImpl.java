package com.unichain.pay.service.impls;

import com.unichain.pay.dao.MerchantAppMapper;
import com.unichain.pay.pojo.query.CompanyAppQuery;
import com.unichain.pay.service.MerchantAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MerchantAppServiceImpl implements MerchantAppService {

    @Autowired
    private MerchantAppMapper merchantAppMapper;

    @Override
    public MerchantAppMapper getCrudRepository() {
        return merchantAppMapper;
    }

    public CompanyAppQuery createQuery() {
        return null;
    }
}
