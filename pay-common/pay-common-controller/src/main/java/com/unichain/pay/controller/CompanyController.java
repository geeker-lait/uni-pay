package com.unichain.pay.controller;

import com.unichain.framework.common.CrudController;
import com.unichain.pay.entity.Merchant;
import com.unichain.pay.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController implements CrudController<Merchant, MerchantService> {


    @Autowired
    private MerchantService merchantService;

    @Override
    public MerchantService getCrudService() {
        return merchantService;
    }
}
