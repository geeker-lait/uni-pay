package com.unichain.pay.core;

import lombok.Data;

@Data
public class PayResult {

    //  状态 失败：FAIL,成功：SUCCESS
    private boolean success;

    private PayStatusCode payStatusCode;



    //  支付订单编号
    private String paymentId;

    //  后续流程处理状态
    //  0：需要接收短信验证码，且需要调用快捷协议支付确认支付接口；
    //  1：不需要接收短信验证码，且需要调用快捷协议支付确认支付接口；
    //  3：不需要调用快捷协议支付确认支付接口；
    private Integer needSms;

    //  是否已经绑过卡
    private boolean hasBindCard;

    //  返回结果
    private String resultMsg;



}
