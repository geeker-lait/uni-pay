//package com.unichain.pay.gateway.interceptor;
//
//import com.unichain.pay.core.*;
//import com.unichain.pay.biz.PayRule;
//import com.unichain.pay.gateway.PayRouter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
///**
// * 通道拦截器
// */
//public class ChannelInterceptor implements Interceptor {
//    @Autowired
//    PayRouter payRouter;
//
//    @Autowired
//    @Qualifier("defaultPayRule")
//    PayRule payRule;
//
//    @Override
//    public void afterHandle(PayRequest payRequest, PayResponse payResponse) {
//
//    }
//
//    @Override
//    public void preHandle(PayRequest payRequest) {
//
//    }
//
////    @Override
////    public void afterHandle(AbstractPayRequest payRequest, DefaultPayResponse payResponse) {
////
////    }
////
////    @Override
////    public void preHandle(AbstractPayRequest payRequest, DefaultPayResponse payResponse) {
////
//////        String CODE = payResponse.getPayMessage().getCode();
////        // id code == false
////
////        // 重新获取通道
////        /*Payable payable = payRule.ramdom();
////
////        payRequest.setPayChannel();
////
////        payDispatcherBak.dispatch(payRequest,payResponse);*/
////
////        Channel payChannel = payRule.choosePayChannel(new ArrayList<>());
////        payRequest.setPayChannel(payChannel);
////
//////        payDispatcher.dispatch(payRequest,payResponse,pa);
////    }
//}
