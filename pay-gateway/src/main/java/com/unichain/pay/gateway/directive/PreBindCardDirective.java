package com.unichain.pay.gateway.directive;

import com.unichain.pay.core.*;
import com.unichain.pay.entity.AppMerchantChannel;
import com.unichain.pay.entity.Directive;
import com.unichain.pay.entity.MerchantChannel;
import com.unichain.pay.service.*;
import com.unichain.pay.utils.BankCardNoUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/24/2019
 * @Description ${Description}
 */
@Service
public class PreBindCardDirective implements DirectiveRouting, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private BindedRecordService bindedRecordervice;

    @Autowired
    private AppMerchantChannelService appMerchantChannelService;

    @Autowired
    private MerchantChannelService merchantChannelService;

    @Autowired
    private ChannelBankService channelBankService;
    @Autowired
    private DirectiveService directiveService;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public PayResponse routing(PayRequest payRequest) {
        PayResponse payResponse = null;
        // 0、判断有无绑卡，如果已经绑定模拟发送验证码，让用户继续往下走支付流程
        if (bindedRecordervice.hasBindedCard(payRequest.getAppId(), payRequest.getAccountId(), payRequest.getBankcard())) {
            // todo 模式发送验证码 待补充
            // 先返回
            return payResponse;

        }

        // 1、根据appId 获取商户应用通道集合，并按权重从高到低排序
        List<AppMerchantChannel> appMerchantChannels = appMerchantChannelService.getSortedAppMerchantChannelsByAppId(payRequest.getAppId());
        // 借助工具类获取bankcode
        String bankCode = BankCardNoUtil.getBankCardNo(payRequest.getBankcard());
        // 2、根据银行卡获取支持通道ID集合，并按权重从高到低排序
        List<Long> bankChannelIdList = channelBankService.getSortedChannelIdListByBankcard(bankCode);

        // 3、根据1和2步骤中的条件，选择支持当前银行卡的商户通道集合
        List<MerchantChannel> merchantChannelList = selectMerchantChannel(appMerchantChannels, bankChannelIdList);
        // 3.1、递归调用
        payResponse = recursion(null, merchantChannelList, payRequest);
        return payResponse;
    }


    /**
     * 递归商户通道
     *
     * @param merchantChannelList
     * @return
     */
    public PayResponse recursion(MerchantChannel merchantChannel, List<MerchantChannel> merchantChannelList, PayRequest payRequest) {

        if (merchantChannel == null && merchantChannelList.size() > 0) {
            merchantChannel = merchantChannelList.get(0);
        }

        // 4、根据3选择出来的商户通道的ID和指令名称获取具体的指令
        Directive directive = directiveService.getDirectiveByChannelIdAndChannelName(merchantChannel.getChannelId(), payRequest.getDirectiveName().name());

        // 5、根据商户通道和指令创建通道参数配置对象
        ChannelConfig channelConfig = buildChannelConfig(merchantChannel, directive);

        // 6、根据具体指令CODE获取具体的支付指令对象
        PayDirective payDirective = applicationContext.getBean(directive.getCode(), PayDirective.class);

        // 7、执行
        PayResponse payResponse = payDirective.exec(payRequest, channelConfig);
        PayResult payResult = payResponse.getPayResult();
        // 不是预留手机号
        if (payResult.getPayStatusCode().code() == PayStatusCode.NOT_BANK_PHONE.code()) {
            return payResponse;
        }
        // 执行失败换下一个通道继续执行
        if (!payResult.isSuccess()) {
            int i = merchantChannelList.indexOf(merchantChannel);
            // 获取下一个去执行
            merchantChannel = merchantChannelList.get(i + 1);
            recursion(merchantChannel, merchantChannelList, payRequest);
        }
        // 8、返回执行结果
        return payResponse;
    }


    private List<MerchantChannel> selectMerchantChannel(List<AppMerchantChannel> merchantAppChannelList, List<Long> bankChannelIdList) {
        List<MerchantChannel> merchantChannelList = new ArrayList<>();
        for (AppMerchantChannel merchantAppChannel : merchantAppChannelList) {
            for (Long channelId : bankChannelIdList) {
                // 找出所有商户开通的通道并且当前银行卡也支持的通道集合
                if (merchantAppChannel.getChannelId() == channelId) {
                    MerchantChannel merchantChannel = new MerchantChannel();
                    merchantChannel.setChannelId(channelId);
                    merchantChannel.setMerchantId(merchantAppChannel.getMerchantId());
                    merchantChannel = merchantChannelService.findOne(merchantChannel);
                    merchantChannelList.add(merchantChannel);
                }
            }
        }
        return merchantChannelList;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
