package com.unichain.pay.service.impls;

import com.unichain.pay.dao.AppMerchantChannelMapper;
import com.unichain.pay.entity.AppMerchantChannel;
import com.unichain.pay.service.AppMerchantChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppMerchantChannelServiceImpl implements AppMerchantChannelService {

    @Autowired
    private AppMerchantChannelMapper appMerchantChannelMapper;

    @Override
    public AppMerchantChannelMapper getCrudRepository() {
        return appMerchantChannelMapper;
    }


    /**
     * @param appId
     * @return
     */
    @Cacheable(value = "uni-payment", key = "'AppMerchantChannelService#getSortedAppMerchantChannelsByAppId#'+#appId")
    public List<AppMerchantChannel> getSortedAppMerchantChannelsByAppId(String appId) {
        AppMerchantChannel appMerchantChannel = new AppMerchantChannel();
        appMerchantChannel.setAppId(appId);
        List<AppMerchantChannel> merchantAppChannelList = appMerchantChannelMapper.findAll(Example.of(appMerchantChannel), Sort.by(Sort.Direction.DESC, "weight"));
        return merchantAppChannelList;
    }
}
