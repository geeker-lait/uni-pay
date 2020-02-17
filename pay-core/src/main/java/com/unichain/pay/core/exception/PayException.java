package com.unichain.pay.core.exception;

/**
 * 支付异常
 */
public class PayException {
    private String errorCode;
    private String errorMsg;
    private String content;

    public PayException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public PayException(String errorCode, String errorMsg, String content) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.content = content;
    }


}
