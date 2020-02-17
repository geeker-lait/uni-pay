package com.unichain.pay.gateway;

import com.unichain.framework.common.ResponseData;
import com.unichain.pay.core.DefaultPayRequest;
import com.unichain.pay.core.DirectiveName;
import com.unichain.pay.core.PayRequest;
import com.unichain.pay.core.PayResponse;
import com.unichain.service.api.BizIdCode;
import com.unichain.service.api.Token;
import com.unichain.service.id.IdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * GrantDirective,
 * LoanDirective,
 * QueryDirective,
 * RefundDirective,
 * RepaymentDirective,
 * SignDirective,
 * BindCardDirective,
 * TransferDirective,
 * BankcardBindVerify,
 * WithholdDirective
 */
@RestController
public class PayController {
    Logger logger = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private PayRouting payRouting;

    @Autowired
    private IdService idGenerater;

    /**
     * 绑卡
     *
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @PostMapping(value = "/preBindcard")
    @ResponseBody
    public ResponseData preBindcard(Token token, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        PayRequest payRequest = new DefaultPayRequest();
        payRequest.setDirectiveName(DirectiveName.PRE_BIND_CARD_DIRECTIVE).buildPayParam(httpServletRequest);
        initPayRequest(payRequest, token, BizIdCode.PAY_BINDCARD_ID);
        PayResponse payResponse = payRouting.routing(payRequest);
        return ResponseData.ok(payResponse);
    }

    /**
     * 绑卡校验
     *
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @PostMapping(value = "/bindcard")
    @ResponseBody
    public ResponseData bindcard(Token token, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        PayRequest payRequest = new DefaultPayRequest();
        payRequest.setDirectiveName(DirectiveName.BIND_CARD_DIRECTIVE).buildPayParam(httpServletRequest);
        initPayRequest(payRequest, token, BizIdCode.PAY_BINDCARD_ID);
        PayResponse payResponse = payRouting.routing(payRequest);
        return ResponseData.ok(payResponse);
    }


    /**
     * 代扣
     *
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @PostMapping(value = "/prePay")
    @ResponseBody
    public ResponseData prePay(Token token, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        PayRequest payRequest = new DefaultPayRequest();
        payRequest.setDirectiveName(DirectiveName.PRE_PAY_DIRECTIVE).buildPayParam(httpServletRequest);

        initPayRequest(payRequest, token, BizIdCode.PAY_WITHHOLD_ID);
        PayResponse payResponse = payRouting.routing(payRequest);
        return ResponseData.ok(payResponse);
    }


    /**
     * 转账
     *
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @PostMapping(value = "/pay")
    @ResponseBody
    public ResponseData transferDirective(Token token, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        PayRequest payRequest = new DefaultPayRequest();
        payRequest.setDirectiveName(DirectiveName.PAY_DIRECTIVE).buildPayParam(httpServletRequest);
        initPayRequest(payRequest, token, BizIdCode.PAY_FOR_ANOTHER_ID);
        PayResponse payResponse = payRouting.routing(payRequest);
        return ResponseData.ok(payResponse);
    }


//    /**
//     * 代付
//     *
//     * @param httpServletRequest
//     * @param httpServletResponse
//     */
//    @PostMapping(value = "/payForAnotherDirective")
//    @ResponseBody
//    public ResponseData payForAnotherDirective(Token token, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        PayRequest payRequest = new DefaultPayRequest();
//        payRequest.setDirectiveName(DirectiveName.PayForAnotherDirective).buildPayParam(httpServletRequest);
//        initPayRequest(payRequest, token, BizIdCode.PAY_FOR_ANOTHER_ID);
//        PayResponse payResponse = payRouting.routing(payRequest);
//        return ResponseData.ok(payResponse);
//    }
//
//
//
//
//    @PostMapping(value = "/refund")
//    @ResponseBody
//    public ResponseData refund(Token token, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        PayRequest payRequest = new DefaultPayRequest();
//        payRequest.setDirectiveName(DirectiveName.RefundDirective).buildPayParam(httpServletRequest);
//        initPayRequest(payRequest, token, BizIdCode.PAY_REFUND_ID);
//        PayResponse payResponse = payRouting.routing(payRequest);
//        return ResponseData.ok(payResponse);
//    }


    private void initPayRequest(PayRequest payRequest, Token token, BizIdCode bizIdCode) {
        if (token != null) {
            payRequest.setAccountId(token.getAccountId());
            payRequest.setAppId(token.getAppId());
            payRequest.setUserId(token.getUserId());
            String paymentId = idGenerater.generateId(token.getAppId(), bizIdCode);
            payRequest.setPaymentId(paymentId);
        }
    }
}
