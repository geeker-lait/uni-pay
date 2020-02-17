package com.unichain.pay.core;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/27/2019
 * @Description ${Description}
 */
public enum PayStatusCode {

    NOT_SUPPORT_BANKCARD(400000000, "不支持的银行卡"),
    NOT_SUFFICIENT_FUNDS(400000001, "账户可用余额不足"),
    NOT_BANK_PHONE(400000002, "手机号码与预留时不符"),

    PAY_NEED_SMS_CODE(400000003, "交易需要验证码"),
    ;
    private int code;
    private String msg;

    PayStatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return this.code;
    }

    public String msg() {
        return this.msg;
    }
}
