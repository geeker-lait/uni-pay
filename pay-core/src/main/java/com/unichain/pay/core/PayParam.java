package com.unichain.pay.core;


public interface PayParam {
    // 签名私钥
    PayParam setSign(String privateKey);

    // 转换具体支付参数
    PayParam convert(PayRequest payRequest);

    // 参数加密
    default PayParam encrypt(String secretKey) {
        return this;
    }

    // 参数解密
    default PayParam decrypt(String secretKey) {
        return this;
    }

}
