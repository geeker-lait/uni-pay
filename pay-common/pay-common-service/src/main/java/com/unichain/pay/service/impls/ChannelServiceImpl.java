package com.unichain.pay.service.impls;

import com.unichain.pay.dao.ChannelMapper;
import com.unichain.pay.pojo.query.ChannelQuery;
import com.unichain.pay.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public ChannelMapper getCrudRepository() {
        return channelMapper;
    }

    public ChannelQuery createQuery() {
        return null;
    }
}
