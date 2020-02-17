package com.unichain.pay.controller;

import com.unichain.framework.common.CrudController;
import com.unichain.pay.entity.Directive;
import com.unichain.pay.service.DirectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/2/2019
 * @Description ${Description}
 */
@RestController
@RequestMapping("directive")
public class DirectiveController implements CrudController<Directive, DirectiveService> {

    @Autowired
    private DirectiveService directiveService;

    @Override
    public DirectiveService getCrudService() {
        return directiveService;
    }


}
