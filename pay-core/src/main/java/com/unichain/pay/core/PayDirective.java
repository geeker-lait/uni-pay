package com.unichain.pay.core;

/**
 * 支付指令
 */
public interface PayDirective<PP extends PayParam, PR extends PayResponse> {
    /**
     * 执行支付指令
     *
     * @param payRequest
     * @return
     */
    PayResponse exec(PayRequest payRequest, ChannelConfig channelConfig);

    /**
     * 根据payRequest构建参数
     *
     * @param payRequest
     * @return
     */
    PP buildPayParam(PayRequest payRequest, ChannelConfig channelConfig);


    /**
     * 获取指令码
     *
     * @return
     */
    String getDirectiveCode();

    /**
     * 记录
     * @param payParam
     * @param payRequest
     * @param payResponse
     * @return
     */
    PR record(PP payParam, PayRequest payRequest, PR payResponse);

}
