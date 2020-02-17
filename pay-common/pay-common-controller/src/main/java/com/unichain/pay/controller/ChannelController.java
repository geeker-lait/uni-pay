package com.unichain.pay.controller;

import com.unichain.framework.common.CrudController;
import com.unichain.pay.entity.Channel;
import com.unichain.pay.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/channel")
public class ChannelController implements CrudController<Channel, ChannelService> {

    @Autowired
    private ChannelService channelService;

    @Override
    public ChannelService getCrudService() {
        return channelService;
    }
}
