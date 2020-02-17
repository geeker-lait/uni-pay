package com.unichain.pay.gateway.directive;

import com.unichain.pay.core.PayRequest;
import com.unichain.pay.core.PayResponse;
import com.unichain.pay.service.AppMerchantChannelService;
import com.unichain.pay.service.BindedRecordService;
import com.unichain.pay.service.ChannelBankService;
import com.unichain.pay.service.MerchantChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/24/2019
 * @Description ${Description}
 */
@Service
public class BindCardDirective implements DirectiveRouting {

    @Autowired
    private BindedRecordService bindedRecordervice;

    @Autowired
    private AppMerchantChannelService appMerchantChannelService;

    @Autowired
    private MerchantChannelService merchantChannelService;

    @Autowired
    private ChannelBankService channelBankService;

    @Override
    public PayResponse routing(PayRequest payRequest) {
        PayResponse payResponse = null;


        return null;
    }
}
