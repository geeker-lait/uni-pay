package com.unichain.pay.channel.mfe88;

import cn.hutool.core.bean.BeanUtil;
import com.unichain.pay.channel.mfe88.demo.entity.Trade;
import com.unichain.pay.channel.mfe88.utils.PropUtils;
import com.unichain.pay.channel.mfe88.utils.TraderRSAUtil;
import com.unichain.pay.core.PayParam;

import java.net.URLEncoder;

import static com.unichain.pay.channel.mfe88.demo.Demo.rsasign;
import static com.unichain.pay.channel.mfe88.demo.UppDemo.md5UpperCase;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/28/2019
 * @Description ${Description}
 */
public interface Mfe88SignPayParam extends PayParam {

    default PayParam sign(String privateKey,String secretKey) {
        Trade trade = new Trade();
        BeanUtil.copyProperties(this, trade);
        trade.setMerchantPrivateKey(privateKey);
        trade.setKeyPassword(secretKey);
        trade.setKeyType("RSACert");
        //String s = Demo.createLinkString(BeanUtil.beanToMap(payParam));
        String s = PropUtils.beanToAsciiSortString1(this);
        try {
            this.setSign(generateSign(trade, s));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    default String generateSign(Trade bean, String content) throws Exception {
        String sign = "";
        if ("2".equals(bean.getSignType())) {
            try {
                //System.out.println("rsa签串:" + content);
                sign = rsasign(content, bean.getPrivateKey());
                sign = URLEncoder.encode(sign, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("3".equals(bean.getSignType())) {
            //System.out.println("RSACert签串:" + content);
            sign = TraderRSAUtil.getInstance().sign(content, bean.getMerchantPrivateKey().trim(), bean.getKeyPassword().trim());// 商户签名，商户私钥
//            sign = TraderRSAUtil.getInstance().sign(content, , bean.getKeyPassword().trim());// 商户签名，商户私钥
            //System.out.println("RSACert sign:" + sign);
        } else {
            sign = md5UpperCase(content + bean.getMd5Key(), "UTF-8");// 商户签名数据
            //System.out.println("md5签串:" + content + bean.getMd5Key());
        }
        return sign;
    }

}
