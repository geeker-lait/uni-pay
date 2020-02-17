package com.unichain.pay.core;

import lombok.Data;

import java.io.Serializable;

/**
 * 支付响应
 */
@Data
public class PayResponse implements Serializable {


    private PayResult payResult;
    private String code;
    private Integer status;

    public static PayResponse ok() {
        PayResponse payResponse = new PayResponse();
        return payResponse;
    }

    public static PayResponse error() {
        PayResponse payResponse = new PayResponse();
        return payResponse;
    }


}
