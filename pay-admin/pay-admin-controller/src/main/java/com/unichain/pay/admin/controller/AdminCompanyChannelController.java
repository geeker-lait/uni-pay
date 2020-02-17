package com.unichain.pay.admin.controller;

import com.unichain.framework.common.CrudController;
import com.unichain.pay.entity.CompanyChannel;
import com.unichain.pay.service.CompanyChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/companyChannel")
public class AdminCompanyChannelController implements CrudController<CompanyChannel, CompanyChannelService> {


    @Autowired
    private CompanyChannelService companyChannelService;

    @Override
    public CompanyChannelService getCrudService() {
        return companyChannelService;
    }
}
