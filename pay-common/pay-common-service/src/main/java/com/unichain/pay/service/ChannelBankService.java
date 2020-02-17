package com.unichain.pay.service;

import com.unichain.framework.common.CrudService;
import com.unichain.pay.dao.ChannelBankMapper;
import com.unichain.pay.entity.ChannelBank;

import java.util.List;

public interface ChannelBankService extends CrudService<ChannelBank, ChannelBankMapper> {

    List<Long> getSortedChannelIdListByBankcard(String bankcard);

}
