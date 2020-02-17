package com.unichain.pay.channel.mfe88.domain;

import com.unichain.pay.core.PayResponse;
import lombok.Data;

@Data
public class RefundOrderResponse extends PayResponse {

    private String merchantNo;
    private String dealCode;
    private String dealMsg;
    private String orderNo;
    private String cxOrderNo;
    private String sign;

}
