package com.unichain.pay.admin.controller;

import com.unichain.framework.common.CrudController;
import com.unichain.pay.entity.Company;
import com.unichain.pay.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/company")
public class AdminCompanyController implements CrudController<Company, CompanyService> {

    @Autowired
    private CompanyService companyService;

    @Override
    public CompanyService getCrudService() {
        return companyService;
    }
}
