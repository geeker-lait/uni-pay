package com.unichain.pay.service.impls;

import com.unichain.pay.dao.MerchantMapper;
import com.unichain.pay.pojo.query.CompanyQuery;
import com.unichain.pay.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public MerchantMapper getCrudRepository() {
        return merchantMapper;
    }

    public CompanyQuery createQuery() {
        return null;
    }
}
