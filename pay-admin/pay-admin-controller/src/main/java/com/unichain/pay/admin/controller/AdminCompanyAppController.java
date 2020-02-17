package com.unichain.pay.admin.controller;

import com.unichain.framework.common.CrudController;
import com.unichain.pay.entity.CompanyApp;
import com.unichain.pay.service.CompanyAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/companyApp")
public class AdminCompanyAppController implements CrudController<CompanyApp, CompanyAppService> {


    @Autowired
    private CompanyAppService companyAppService;

    @Override
    public CompanyAppService getCrudService() {
        return companyAppService;
    }
}
