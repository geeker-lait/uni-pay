package com.unichain.pay.gateway.directive;

import com.unichain.pay.core.PayRequest;
import com.unichain.pay.core.PayResponse;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/27/2019
 * @Description ${Description}
 */
public class PaymentDirective implements DirectiveRouting {
    @Override
    public PayResponse routing(PayRequest payRequest) {
        return null;
    }
}
