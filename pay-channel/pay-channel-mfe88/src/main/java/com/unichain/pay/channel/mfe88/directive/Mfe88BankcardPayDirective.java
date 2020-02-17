package com.unichain.pay.channel.mfe88.directive;

import com.unichain.pay.channel.mfe88.domain.BankcardPayParam;
import com.unichain.pay.channel.mfe88.domain.BankcardPayResponse;
import com.unichain.pay.core.ChannelConfig;
import com.unichain.pay.core.PayDirective;
import com.unichain.pay.core.PayRequest;
import com.unichain.pay.core.PayResponse;
import org.springframework.stereotype.Service;

@Service("Mfe88BankcardPayDirective")
public class Mfe88BankcardPayDirective implements PayDirective< BankcardPayParam, BankcardPayResponse> {
    @Override
    public PayResponse exec(PayRequest payRequest, ChannelConfig channelConfig) {
        return null;
    }

    @Override
    public BankcardPayParam buildPayParam(PayRequest payRequest, ChannelConfig channelConfig) {
        return null;
    }

    @Override
    public String getDirectiveCode() {
        return null;
    }

    @Override
    public BankcardPayResponse record(BankcardPayParam payParam, PayRequest payRequest, BankcardPayResponse payResponse) {
        return null;
    }

//    @Autowired
//    private ChannelDirectiveRecordService channelDirectiveRecordService;
//
//    @Override
//    public PayResponse exec(Mfe88ChannelDirecvite channelDirective, BankcardPayParam bankcardPayParam, PayRequest payRequest) {
//        bankcardPayParam.setMerchantNo(channelDirective.getMerchantNo());
//
//        String data = Mfe88PayRequestHandler.build(bankcardPayParam, channelDirective)
//                /*.sign(channelDirective.getPrivateKey())
//                .encrypt(channelDirective.getMerchantNo(), channelDirective.getSecretKey())*/
//                .exec(channelDirective.getDirectiveUri());
//        return record(bankcardPayParam, payRequest, data);
//
//    }
//
//    @Override
//    public BankcardPayParam buildPayParam(PayRequest payRequest) {
//        BankcardPayParam bankcardPayParam = new BankcardPayParam();
//        Mfe88PayRequestHandler.buildPayParam(bankcardPayParam, payRequest);
//        return bankcardPayParam;
//    }
//
//    @Override
//    public Mfe88ChannelDirecvite buildChannelDirective() {
//        return new Mfe88ChannelDirecvite();
//    }
//
//    @Override
//    public String getDirectiveCode() {
//        return "Mfe88BankcardPayDirective";
//    }
//
//    @Override
//    public PayResponse record(BankcardPayParam bankcardPayParam, PayRequest payRequest, String data) {
//        // 保存记录
//        ChannelDirectiveRecord channelDirectiveRecord = new ChannelDirectiveRecord();
//
//        channelDirectiveRecord.setAccountId(payRequest.getAccountId());
//        channelDirectiveRecord.setAppId(payRequest.getAppId());
//        channelDirectiveRecord.setChannelId(payRequest.getChannelId());
//        channelDirectiveRecord.setUserId(payRequest.getUserId());
//        channelDirectiveRecord.setCompanyId(payRequest.getCompanyId());
//        channelDirectiveRecord.setDirectiveCode(getDirectiveCode());
//        channelDirectiveRecord.setChannelId(payRequest.getChannelId());
//        BankcardPrePayResponse bankcardPrePayResponse = JSONObject.parseObject(data, BankcardPrePayResponse.class);
//        String returnCode = bankcardPrePayResponse.getDealCode();
//        channelDirectiveRecord.setReturnCode(returnCode);
//        channelDirectiveRecord.setPaymentId(bankcardPayParam.getOrderNo());
//        channelDirectiveRecord.setReturnMsg(bankcardPrePayResponse.getDealMsg());
//        Map resultMap = new HashMap();
//        PayResponse result = new PayResponse();
//
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
//            resultMap.put("paymentId", bankcardPayParam.getOrderNo());
//
//            /*payResult.setStatus(PayResultStatusEnum.SUCCESS);
//            payResult.setPaymentId(bankcardPayParam.getOrderNo());*/
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
