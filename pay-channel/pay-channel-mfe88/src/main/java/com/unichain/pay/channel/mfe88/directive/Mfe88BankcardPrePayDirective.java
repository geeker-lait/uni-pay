package com.unichain.pay.channel.mfe88.directive;

import com.unichain.pay.channel.mfe88.domain.BankcardPrePayParam;
import com.unichain.pay.channel.mfe88.domain.BankcardPrePayResponse;
import com.unichain.pay.core.ChannelConfig;
import com.unichain.pay.core.PayDirective;
import com.unichain.pay.core.PayRequest;
import com.unichain.pay.core.PayResponse;
import org.springframework.stereotype.Service;

@Service("Mfe88BankcardPrePayDirective")
public class Mfe88BankcardPrePayDirective implements PayDirective< BankcardPrePayParam,BankcardPrePayResponse> {
    @Override
    public PayResponse exec(PayRequest payRequest, ChannelConfig channelConfig) {
        return null;
    }

    @Override
    public BankcardPrePayParam buildPayParam(PayRequest payRequest, ChannelConfig channelConfig) {
        return null;
    }

    @Override
    public String getDirectiveCode() {
        return null;
    }

    @Override
    public BankcardPrePayResponse record(BankcardPrePayParam payParam, PayRequest payRequest, BankcardPrePayResponse payResponse) {
        return null;
    }

//    @Autowired
//    private ChannelDirectiveRecordService channelDirectiveRecordService;
//
//    @Override
//    public PayResponse exec(Mfe88ChannelDirecvite channelDirective, BankcardPrePayParam bankcardPrePayParam, PayRequest payRequest) {
//        bankcardPrePayParam.setMerchantNo(channelDirective.getMerchantNo());
//
//        String data = Mfe88PayRequestHandler.build(bankcardPrePayParam, channelDirective)
//                /* .sign(channelDirective.getPrivateKey())
//                 .encrypt(channelDirective.getMerchantNo(), channelDirective.getSecretKey())*/
//                .exec(channelDirective.getDirectiveUri());
//        System.out.println("responseData:" + data);
//        return record(bankcardPrePayParam, payRequest, data);
//
//    }
//
//    @Override
//    public BankcardPrePayParam buildPayParam(PayRequest payRequest) {
//        BankcardPrePayParam bankcardPrePayParam = new BankcardPrePayParam();
//        Mfe88PayRequestHandler.buildPayParam(bankcardPrePayParam, payRequest);
//        return bankcardPrePayParam;
//    }
//
//    @Override
//    public Mfe88ChannelDirecvite buildChannelDirective() {
//        return new Mfe88ChannelDirecvite();
//    }
//
//    @Override
//    public String getDirectiveCode() {
//        return "Mfe88BankcardPrePayDirective";
//    }
//
//    @Override
//    public PayResponse record(BankcardPrePayParam bankcardPrePayParam, PayRequest payRequest, String data) {
//        // 保存记录
//        ChannelDirectiveRecord channelDirectiveRecord = new ChannelDirectiveRecord();
//
//        channelDirectiveRecord.setAccountId(payRequest.getAccountId());
//        channelDirectiveRecord.setAppId(payRequest.getAppId());
//        channelDirectiveRecord.setChannelId(payRequest.getChannelId());
//        channelDirectiveRecord.setUserId(payRequest.getUserId());
//        channelDirectiveRecord.setCompanyId(payRequest.getCompanyId());
//        channelDirectiveRecord.setDirectiveCode(getDirectiveCode());
//        //String aesKey = "191e257a18e6439ab8a7573f0b278394";   //test
//        String aesKey = "84ae078cd7ab4fe4a0727e1ede7512d5";     //pord
//        channelDirectiveRecord.setBankcard(Demo.AESDncode2(bankcardPrePayParam.getBankCardNo(), aesKey));
//        channelDirectiveRecord.setPaymentId(payRequest.getPaymentId());
//        channelDirectiveRecord.setChannelId(payRequest.getChannelId());
//        BankcardPrePayResponse bankcardPrePayResponse = JSONObject.parseObject(data, BankcardPrePayResponse.class);
//        String returnCode = bankcardPrePayResponse.getDealCode();
//        channelDirectiveRecord.setReturnCode(returnCode);
//        channelDirectiveRecord.setReturnMsg(bankcardPrePayResponse.getDealMsg());
//        try {
//            String orderAmount = AmountUtils.changeF2Y(bankcardPrePayParam.getOrderAmount());
//            channelDirectiveRecord.setAmount(new BigDecimal(orderAmount));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        PayResponse result = new PayResponse();
//        Map resultMap = new HashMap();
//        //PayResult payResult = new PayResult();
//        //下单结果代码，为 10000 代表受理成功，否则受理失败，最终结果以代付查询为准详细参见 5.3 代码表
//        if (!returnCode.equals("10000")) {
//            // 0默认表示成功，1表示失败
//            channelDirectiveRecord.setState(1);
//            resultMap.put("status", "FAIL");
//
//            //payResult.setStatus(PayResultStatusEnum.FAIL);
//        } else {
//            resultMap.put("status", "SUCCESS");
//            resultMap.put("paymentId", payRequest.getPaymentId());
//            //  0：需要接收短信验证码，且需要调用快捷协议支付确认支付接口；
//            //  1：不需要接收短信验证码，且需要调用快捷协议支付确认支付接口；
//            //  3：不需要调用快捷协议支付确认支付接口；
//            resultMap.put("needSms", bankcardPrePayResponse.getNeedSms());
//
//            /*payResult.setStatus(PayResultStatusEnum.SUCCESS);
//            payResult.setPaymentId(payRequest.getPaymentId());
//            payResult.setNeedSms(bankcardPrePayResponse.getNeedSms());*/
//
//        }
//        resultMap.put("resultMsg", bankcardPrePayResponse.getDealMsg());
//
//        //payResult.setResultMsg(bankcardPrePayResponse.getDealMsg());
//        result.data(resultMap);
//        channelDirectiveRecordService.save(channelDirectiveRecord);
//        return result;
//    }
}
