package com.unichain.pay.channel.mfe88.directive;

import com.unichain.pay.channel.mfe88.domain.BankcardBindVerfyResponse;
import com.unichain.pay.channel.mfe88.domain.BankcardBindVerifyParam;
import com.unichain.pay.core.ChannelConfig;
import com.unichain.pay.core.PayDirective;
import com.unichain.pay.core.PayRequest;
import com.unichain.pay.core.PayResponse;
import org.springframework.stereotype.Service;


@Service("Mfe88BankcardBindVerifyDirective")
public class Mfe88BankcardBindVerifyDirective implements PayDirective<BankcardBindVerifyParam, BankcardBindVerfyResponse> /*implements PayDirective<BankcardBindParam>*/ {
    @Override
    public PayResponse exec(PayRequest payRequest, ChannelConfig channelConfig) {
        return null;
    }

    @Override
    public BankcardBindVerifyParam buildPayParam(PayRequest payRequeDst, ChannelConfig channelConfig) {
        return null;
    }

    @Override
    public String getDirectiveCode() {
        return null;
    }

    @Override
    public BankcardBindVerfyResponse record(BankcardBindVerifyParam payParam, PayRequest payRequest, BankcardBindVerfyResponse payResponse) {
        return null;
    }


//    @Autowired
//    private ChannelDirectiveRecordService channelDirectiveRecordService;
//
//    @Override
//    public PayResponse exec(Mfe88ChannelDirecvite channelDirective, BankcardBindVerifyParam bankcardBindVerifyParam, PayRequest payRequest) {
//
//        String uri = channelDirective.getDirectiveUri();
////        String merchantNo = channelDirective.getMerchantNo();
////        String publicKey = channelDirective.getPublicKey();
////        String privateKey = channelDirective.getPrivateKey();
//        bankcardBindVerifyParam.setMerchantNo(channelDirective.getMerchantNo());
//        String data = Mfe88PayRequestHandler.build(bankcardBindVerifyParam, channelDirective).exec(uri);
//        return record(bankcardBindVerifyParam, payRequest, data);
//    }
//
//    @Override
//    public BankcardBindVerifyParam buildPayParam(PayRequest payRequest) {
//        BankcardBindVerifyParam bankcardBindVerifyParam = new BankcardBindVerifyParam();
//        Mfe88PayRequestHandler.buildPayParam(bankcardBindVerifyParam, payRequest);
//        return bankcardBindVerifyParam;
//    }
//
//    @Override
//    public Mfe88ChannelDirecvite buildChannelDirective() {
//        return new Mfe88ChannelDirecvite();
//    }
//
//    @Override
//    public PayResponse record(BankcardBindVerifyParam payParam, PayRequest payRequest, String data) {
//        BankcardBindResponse response = JSONUtil.toBean(data, BankcardBindResponse.class);
//
//        ChannelDirectiveRecord save = new ChannelDirectiveRecord();
//        save.setAccountId(payRequest.getAccountId());
//        save.setAppId(payRequest.getAppId());
//        save.setUserId(payRequest.getUserId());
//        save.setDirectiveCode(getDirectiveCode());
//        save.setCompanyId(payRequest.getCompanyId());
//        save.setChannelId(payRequest.getChannelId());
//        save.setReturnCode(response.getDealCode());
//        save.setReturnMsg(response.getDealMsg());
//        save.setPaymentId(payParam.getOrderNo());
//        Map resultMap = new HashMap();
//        PayResponse result = new PayResponse();
//
//        //PayResult payResult = new PayResult();
//        boolean hasBindCard = false;
//        if (response.getDealMsg().contains("不允许重复确认绑定!") && "90001".equals(response.getDealCode())) {
//            resultMap.put("status", "SUCCESS");
//            hasBindCard = true;
//            resultMap.put("hasBindCard", hasBindCard);
//
//            /*payResult.setStatus(PayResultStatusEnum.SUCCESS);
//            payResult.setHasBindCard(hasBindCard);*/
//        } else if (!"10000".equals(response.getDealCode())) {
//            // 0默认表示成功，1表示失败
//            save.setState(1);
//            resultMap.put("status", "FAIL");
//
//            //payResult.setStatus(PayResultStatusEnum.FAIL);
//        } else {
//            resultMap.put("status", "SUCCESS");
//            resultMap.put("hasBindCard", hasBindCard);
//            resultMap.put("paymentId", payParam.getOrderNo());
//
//           /* payResult.setStatus(PayResultStatusEnum.SUCCESS);
//            payResult.setHasBindCard(hasBindCard);
//            payResult.setPaymentId(payParam.getOrderNo());*/
//        }
//
//
//        resultMap.put("resultMsg", response.getDealMsg());
//
//        //payResult.setResultMsg(response.getDealMsg());
//        result.data(resultMap);
//        channelDirectiveRecordService.save(save);
//        return result;
//    }
//
//    @Override
//    public String getDirectiveCode() {
//        return "Mfe88BankcardBindVerifyDirective";
//    }
}
