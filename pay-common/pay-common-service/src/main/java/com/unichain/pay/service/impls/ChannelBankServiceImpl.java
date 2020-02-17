package com.unichain.pay.service.impls;

import com.unichain.pay.dao.ChannelBankMapper;
import com.unichain.pay.entity.ChannelBank;
import com.unichain.pay.service.ChannelBankService;
import com.unichain.pay.utils.BankCardNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChannelBankServiceImpl implements ChannelBankService {

    @Autowired
    private ChannelBankMapper channelBankMapper;

    @Override
    public ChannelBankMapper getCrudRepository() {
        return channelBankMapper;
    }


    @Cacheable(value = "uni-payment", key = "'ChannelBankService#getSortedChannelIdListByBankcard#'+#bankCode")
    public List<Long> getSortedChannelIdListByBankcard(String bankCode) {
        // 这张卡有哪些通道支持
        ChannelBank channelBank = new ChannelBank();
        channelBank.setBankCode(bankCode);
        List<Long> channelIdList = channelBankMapper.findAll(Example.of(channelBank), Sort.by(Sort.Direction.DESC, "weight")).stream().map(ChannelBank::getChannelId)
                .collect(Collectors.toList());
        return channelIdList;
    }
}
