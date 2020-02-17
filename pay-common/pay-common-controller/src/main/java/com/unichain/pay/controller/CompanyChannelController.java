package com.unichain.pay.controller;

import com.unichain.framework.common.CrudController;
import com.unichain.pay.entity.MerchantChannel;
import com.unichain.pay.service.MerchantChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company-channel")
public class CompanyChannelController implements CrudController<MerchantChannel, MerchantChannelService> {


    @Autowired
    private MerchantChannelService merchantChannelService;

    @Override
    public MerchantChannelService getCrudService() {
        return merchantChannelService;
    }
}
