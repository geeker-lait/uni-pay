package com.unichain.pay.gateway.directive;

import com.unichain.pay.core.ChannelConfig;
import lombok.Data;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/27/2019
 * @Description ${Description}
 */
@Data
public class MerchantChannelConfig implements ChannelConfig {
    // 商户号
    private String merchantNo;
    //
    private String privateKey;

    private String publicKey;

    private String secretKey;

    private String directiveUri;

    private String callbackUrl;

    private String redirectUrl;
}
