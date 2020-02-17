package com.unichain.pay.channel.mfe88.directive;

import com.unichain.pay.channel.mfe88.domain.BankcardBindParam;
import com.unichain.pay.channel.mfe88.domain.BankcardBindResponse;
import com.unichain.pay.core.ChannelConfig;
import com.unichain.pay.core.PayDirective;
import com.unichain.pay.core.PayRequest;
import com.unichain.pay.core.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service("Mfe88BankcardBindDirective")
public class Mfe88BankcardBindDirective implements PayDirective<BankcardBindParam, BankcardBindResponse> {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PayResponse exec(PayRequest payRequest, ChannelConfig channelConfig) {
        // 构建参数
        BankcardBindParam bankcardBindParam = buildPayParam(payRequest, channelConfig);
        // 获取uri
        String uri = channelConfig.getDirectiveUri();
        // 执行
        ResponseEntity<BankcardBindResponse> responseEntity = restTemplate.postForEntity(uri, bankcardBindParam, BankcardBindResponse.class);
        // 返回对象
        BankcardBindResponse bankcardBindResponse = responseEntity.getBody();
        // 参数解密处理
        bankcardBindParam.decrypt(channelConfig.getSecretKey());
        // 记录并返回
        return record(bankcardBindParam, payRequest, bankcardBindResponse);
    }

    /**
     * 记录返回结果
     *
     * @param payRequest
     */
    @Override
    public BankcardBindResponse record(BankcardBindParam payParam, PayRequest payRequest, BankcardBindResponse payResponse) {
        // 这里是否需要记录？如果不记录直接返回
        return payResponse;
    }


    @Override
    public BankcardBindParam buildPayParam(PayRequest payRequest, ChannelConfig channelConfig) {
        BankcardBindParam bankcardBindParam = new BankcardBindParam();
        bankcardBindParam.convert(payRequest).encrypt(channelConfig.getSecretKey()).setSign(channelConfig.getPrivateKey());
        bankcardBindParam.setMerchantNo(channelConfig.getMerchantNo());
        bankcardBindParam.setOrderNo(payRequest.getPaymentId());

        return bankcardBindParam;
    }


    @Override
    public String getDirectiveCode() {
        return "Mfe88BankcardBindDirective";
    }
}
