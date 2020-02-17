package com.unichain.pay.sharelink;

import com.unichain.pay.core.ChannelConfig;
import lombok.Data;

@Data
public class SzsharelinkChannelDirecvite implements ChannelConfig {
    private String privateKey;
    private String merchantNo;
    private String publicKey;
    //银通公钥
    private String secretKey;
    // uri 不一样
    private String directiveUri;
    private String callbackUrl;
    private String redirectUrl;


}
