package com.unichain.pay.core;

public interface ChannelConfig {

    String getPrivateKey();

    ChannelConfig setPrivateKey(String privateKey);

    String getMerchantNo();

    ChannelConfig setMerchantNo(String merchantId);

    String getPublicKey();

    ChannelConfig setPublicKey(String Key);

    String getSecretKey();

    ChannelConfig setSecretKey(String secretKey);

    String getDirectiveUri();

    ChannelConfig setDirectiveUri(String uri);


    String getCallbackUrl();

    ChannelConfig setCallbackUrl(String callbackUrl);


    String getRedirectUrl();

    ChannelConfig setRedirectUrl(String redirectUrl);

}
