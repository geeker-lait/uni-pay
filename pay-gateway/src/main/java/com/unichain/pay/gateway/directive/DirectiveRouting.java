package com.unichain.pay.gateway.directive;

import com.unichain.pay.core.ChannelConfig;
import com.unichain.pay.core.PayRequest;
import com.unichain.pay.core.PayResponse;
import com.unichain.pay.entity.Directive;
import com.unichain.pay.entity.MerchantChannel;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/24/2019
 * @Description ${Description}
 */
public interface DirectiveRouting {
    PayResponse routing(PayRequest payRequest);

    default ChannelConfig buildChannelConfig(MerchantChannel merchantChannel, Directive directive) {
        MerchantChannelConfig merchantChannelConfig = new MerchantChannelConfig();

        merchantChannelConfig.setDirectiveUri(directive.getUri());
        merchantChannelConfig.setCallbackUrl(directive.getCallbackUrl());
        merchantChannelConfig.setRedirectUrl(directive.getRedirectUrl());

        merchantChannelConfig.setMerchantNo(merchantChannel.getMerchantNo());
        merchantChannelConfig.setPrivateKey(merchantChannel.getPrivateKey());
        merchantChannelConfig.setSecretKey(merchantChannel.getSecretKey());
        merchantChannelConfig.setPublicKey(merchantChannel.getPublicKey());
        return merchantChannelConfig;
    }
}
