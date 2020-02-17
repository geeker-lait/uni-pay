package com.unichain.pay.core;

public enum DirectiveName {

    // 预绑卡
    PRE_BIND_CARD_DIRECTIVE,
    // 确认绑卡
    BIND_CARD_DIRECTIVE,

    // 预支付
    PRE_PAY_DIRECTIVE,
    // 确认支付
    PAY_DIRECTIVE,


    // 代付
    PAY_FOR_ANOTHER_DIRECTIVE,
    // 退款
    REFUND_DIRECTIVE_DIRECTIVE;
}
