package com.unichain.pay.core;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/28/2019
 * @Description ${Description}
 */
public class DefaultPayRequest implements PayRequest {

    private String appId;
    private String accountId;
    private String userId;
    private String merchantId;
    private String channelId;
    private String deviceId;
    private String paymentId;
    private String bankcard;
    private String amount;

    // 具体支付参数
    private JSONObject payParams;
    // 支付方式 1支付宝 2微信 3三方支付公司 4四方支付
    private PayTyp payTyp;
    // 指令名称
    private DirectiveName directiveName;


    @Override
    public String getAppId() {
        return appId;
    }

    @Override
    public PayRequest setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    @Override
    public String getAccountId() {

        return accountId;
    }

    @Override
    public PayRequest setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public PayRequest setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public String getMerchantId() {
        return merchantId;
    }

    @Override
    public PayRequest setMerchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    @Override
    public String getChannelId() {
        return channelId;
    }

    @Override
    public PayRequest setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public PayRequest setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @Override
    public String getPaymentId() {
        return paymentId;
    }

    @Override
    public PayRequest setPaymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    @Override
    public String getBankcard() {
        return bankcard;
    }

    @Override
    public PayRequest setBankcard(String bankcard) {
        this.bankcard = bankcard;
        return this;
    }

    @Override
    public String getAmount() {
        return amount;
    }

    @Override
    public PayRequest setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public JSONObject getPayParams() {
        return payParams;
    }

    @Override
    public PayRequest setPayParams(JSONObject payParams) {
        this.payParams = payParams;
        return this;
    }

    @Override
    public PayTyp getPayTyp() {
        return payTyp;
    }

    @Override
    public PayRequest setPayTyp(PayTyp payTyp) {
        this.payTyp = payTyp;
        return this;
    }

    @Override
    public DirectiveName getDirectiveName() {
        return directiveName;
    }

    @Override
    public PayRequest setDirectiveName(DirectiveName directiveName) {
        this.directiveName = directiveName;
        return this;
    }

    /**
     * 创建map请求参数
     *
     * @param httpServletRequest
     * @return
     */
    public PayRequest buildPayParam(HttpServletRequest httpServletRequest) {
        payParams = getRequestParam(httpServletRequest);

        Object oAppId = payParams.get("appId");
        Object oAccountId = payParams.remove("accountId");
        Object oMerchantId = payParams.remove("merchantId");
        //userId = payParamMap.remove("userId").toString();
        payTyp = PayTyp.valueOf(payParams.get("payType").toString());
        if (null != oAppId && StringUtils.isNotBlank(oAppId.toString())) {
            appId = oAppId.toString();
        }
        if (null != oAccountId && StringUtils.isNotBlank(oAccountId.toString())) {
            accountId = oAccountId.toString();
        }

        if (null != oMerchantId && StringUtils.isNotBlank(oMerchantId.toString())) {
            merchantId = oMerchantId.toString();
        }
        if (PayTyp.THIRD == payTyp) {
            bankcard = payParams.get("bankcard").toString();
        } else if (PayTyp.ALIPAY == payTyp) {
            bankcard = "alipay";
        } else {
            bankcard = "weixin";
        }
        return this;
    }

    public static void main(String[] args) {
        PayRequest payRequest = new DefaultPayRequest();
        ;
    }

}
