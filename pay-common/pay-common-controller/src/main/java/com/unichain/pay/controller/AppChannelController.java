package com.unichain.pay.controller;

import com.unichain.framework.common.CrudController;
import com.unichain.pay.entity.AppMerchantChannel;
import com.unichain.pay.service.AppMerchantChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app-channel")
public class AppChannelController implements CrudController<AppMerchantChannel, AppMerchantChannelService> {

    @Autowired
    private AppMerchantChannelService appMerchantChannelService;

    @Override
    public AppMerchantChannelService getCrudService() {
        return appMerchantChannelService;
    }
}
