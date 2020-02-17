package com.unichain.pay.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * 支付请求
 */
public interface PayRequest {

    String getAppId();

    PayRequest setAppId(String appId);

    String getAccountId();

    PayRequest setAccountId(String accountId);

    String getUserId();

    PayRequest setUserId(String userId);

    String getMerchantId();

    PayRequest setMerchantId(String merchantId);

    String getChannelId();

    PayRequest setChannelId(String channelId);

    String getDeviceId();

    PayRequest setDeviceId(String deviceId);

    String getPaymentId();

    PayRequest setPaymentId(String paymentId);

    String getBankcard();

    PayRequest setBankcard(String bankcard);

    String getAmount();

    PayRequest setAmount(String amount);

    JSONObject getPayParams();

    PayRequest setPayParams(JSONObject payParams);

    PayTyp getPayTyp();

    PayRequest setPayTyp(PayTyp payTyp);

    DirectiveName getDirectiveName();

    PayRequest setDirectiveName(DirectiveName directiveName);

    PayRequest buildPayParam(HttpServletRequest httpServletRequest);

    /**
     * @param request
     * @return
     * @throws Exception
     * @author tianwyam
     * @description 从POST请求中获取参数
     */
    default JSONObject getRequestParam(HttpServletRequest request) {
        // 返回参数
        JSONObject params = new JSONObject();
        // 获取内容格式
        String contentType = request.getContentType();
        if (contentType != null && !contentType.equals("")) {
            contentType = contentType.split(";")[0];
        }
        // form表单格式  表单形式可以从 ParameterMap中获取
        if ("appliction/x-www-form-urlencoded".equalsIgnoreCase(contentType)) {
            // 获取参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (parameterMap != null) {
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    params.put(entry.getKey(), entry.getValue()[0]);
                }
            }
        }
        // json格式 json格式需要从request的输入流中解析获取
        if ("application/json".equalsIgnoreCase(contentType)) {
            // 使用 commons-io中 IOUtils 类快速获取输入流内容
            String paramJson = null;
            try {
                paramJson = IOUtils.toString(request.getInputStream(), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            params.putAll(JSON.parseObject(paramJson));
        }
        return params;
    }

}
