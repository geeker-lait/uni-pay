package com.unichain.pay.sharelink.directive;

import cn.hutool.core.bean.BeanUtil;
import com.unichain.pay.sharelink.SzsharelinkChannelDirecvite;
import com.unichain.pay.sharelink.SzsharelinkPayRequestHandler;
import com.unichain.pay.sharelink.domain.BankcardBindVerifyParam;
import com.unichain.pay.sharelink.domain.BankcardBindVerifyResponse;
import com.unichain.pay.sharelink.utils.ECTXmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service("SzsharelinkBankcardBindVerifyDirective")
public class SzsharelinkBankcardBindVerifyDirective extends BaseRecord implements PayDirective<SzsharelinkChannelDirecvite, BankcardBindVerifyParam> {
    @Autowired
    private ChannelDirectiveRecordService channelDirectiveRecordService;


    @Override
    public PayResponse exec(SzsharelinkChannelDirecvite channelDirective, BankcardBindVerifyParam payParam, PayRequest payRequest) {
        String uri = channelDirective.getDirectiveUri();
        payParam.setMerchantId(channelDirective.getMerchantNo());
        // 设置订单号
        Map<String, Object> payParamMap = payRequest.getPayParamMap();
        String smsSendNo = RedisUtils.getStr(payRequest.getAccountId() + "_shareLink_bindCard_smsSendNo");
        smsSendNo = smsSendNo != null ? smsSendNo.replace("\"", "") : null;

        payParam.setSmsSendNo(smsSendNo);

        String data = SzsharelinkPayRequestHandler.build(payParam, channelDirective).exec(uri, ECTXmlUtil.CPREQ_SIREQ);

        return record(payParam, payRequest, data);
    }

    @Override
    public BankcardBindVerifyParam buildPayParam(PayRequest payRequest) {
        BankcardBindVerifyParam param = new BankcardBindVerifyParam();
        SzsharelinkPayRequestHandler.buildPayParam(param, payRequest);
        return param;
    }

    @Override
    public SzsharelinkChannelDirecvite buildChannelDirective() {
        return new SzsharelinkChannelDirecvite();
    }

    @Override
    public String getDirectiveCode() {
        return "SzsharelinkBankcardBindVerifyDirective";
    }

    @Override
    public PayResponse record(BankcardBindVerifyParam payParam, PayRequest payRequest, String data) {
        ChannelDirectiveRecord save = super.createChannelDirectiveRecord(payRequest);
        Map<String, String> resultMap = ECTXmlUtil.xmlToMap(data);
        BankcardBindVerifyResponse response = BeanUtil.mapToBean(resultMap, BankcardBindVerifyResponse.class, true);
        save.setDirectiveCode(getDirectiveCode());
        save.setReturnCode(response.getRetFlag());
        save.setReturnMsg(response.getResultMsg());
        save.setPaymentId(payParam.getMerOrderId());
        save.setChannelId(payRequest.getChannelId());
        save.setProtocolId(response.getProtocolId());
        save.setBankcard(payRequest.getBankcard());
        Map resultMap1 = new HashMap();
        PayResponse result = new PayResponse();

        //PayResult payResult = new PayResult();
        if (!"T".equals(response.getRetFlag())) {
            // 0默认表示成功，1表示失败
            save.setState(1);
            resultMap1.put("status","FAIL");

            //payResult.setStatus(PayResultStatusEnum.FAIL);
        } else {
            boolean hasBindCard = false;
            if (!StringUtils.isEmpty(response.getProtocolId())) {
                save.setProtocolId(response.getProtocolId());
                hasBindCard = true;
            }
            resultMap1.put("hasBindCard",hasBindCard);
            resultMap1.put("status","SUCCESS");
            resultMap1.put("paymentId",payParam.getMerOrderId());

             /*payResult.setStatus(PayResultStatusEnum.SUCCESS);
            payResult.setPaymentId(payRequest.getMerOrderId());
            payResult.setHasBindCard(hasBindCard);*/
        }
        resultMap1.put("resultMsg",response.getResultMsg());

        //payResult.setResultMsg(response.getResultMsg());
        result.data(resultMap1);
        channelDirectiveRecordService.save(save);
        return result;
    }
}
