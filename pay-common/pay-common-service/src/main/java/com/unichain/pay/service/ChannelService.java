package com.unichain.pay.service;

import com.unichain.framework.common.CrudService;
import com.unichain.pay.dao.ChannelMapper;
import com.unichain.pay.entity.Channel;
import com.unichain.pay.pojo.query.ChannelQuery;

public interface ChannelService extends CrudService<Channel, ChannelMapper> {
}
