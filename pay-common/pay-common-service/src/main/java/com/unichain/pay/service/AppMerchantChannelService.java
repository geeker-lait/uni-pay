package com.unichain.pay.service;

import com.unichain.framework.common.CrudService;
import com.unichain.pay.dao.AppMerchantChannelMapper;
import com.unichain.pay.entity.AppMerchantChannel;

import java.util.List;
import java.util.stream.Collectors;

public interface AppMerchantChannelService extends CrudService<AppMerchantChannel, AppMerchantChannelMapper> {

    List<AppMerchantChannel> getSortedAppMerchantChannelsByAppId(String appId);


}
