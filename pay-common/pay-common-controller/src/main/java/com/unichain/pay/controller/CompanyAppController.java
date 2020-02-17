package com.unichain.pay.controller;

import com.unichain.framework.common.CrudController;
import com.unichain.pay.entity.MerchantApp;
import com.unichain.pay.service.MerchantAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company-app")
public class CompanyAppController implements CrudController<MerchantApp, MerchantAppService> {


    @Autowired
    private MerchantAppService merchantAppService;

    @Override
    public MerchantAppService getCrudService() {
        return merchantAppService;
    }
}
