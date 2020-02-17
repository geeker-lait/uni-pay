package com.unichain.pay.api.client;

import com.unichain.framework.common.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 11/30/2019
 * @Description ${Description}
 */
@FeignClient(value = "pay-gateway-application" ,path="payment")
public interface PaymentFeignClient {

    @PostMapping(value = "/bankcardBind")
    ResponseData bankcardBind(@RequestHeader("Token") String token);





}
