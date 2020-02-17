//package com.unichain.pay.gateway.interceptor;
//
//import com.unichain.pay.core.*;
//import com.unichain.pay.biz.IBizChannelDirectiveRuleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DirectiveInterceptor implements Interceptor {
//    @Autowired
//    IBizChannelDirectiveRuleService bizChannelDirectiveRuleServicev;
//
//    @Autowired
//    RedisTemplate redisTemplate;
//    // 规则处理器
//    //@Autowired
//    //RuleHandler ruleHandler;
//
//    @Override
//    public void afterHandle(PayRequest payRequest, PayResponse payResponse) {
//
//    }
//
//    @Override
//    public void preHandle(PayRequest payRequest) {
//
//        // 根据规则选取支付具体的通道指令
//        Rules rule = null;
//        //Payable payable = ruleHandler.selectPayable(list,rule);
//        //payRequest
//
//        //List directives = directiveService.getDirective(payDirective);
//
//
//    }
//}
