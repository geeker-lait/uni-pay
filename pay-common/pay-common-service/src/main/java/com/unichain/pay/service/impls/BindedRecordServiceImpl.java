package com.unichain.pay.service.impls;

import com.unichain.pay.dao.BindedRecordMapper;
import com.unichain.pay.entity.BindedRecord;
import com.unichain.pay.service.BindedRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 2/16/2020
 * @Description ${Description}
 */
@Service
public class BindedRecordServiceImpl implements BindedRecordService {

    @Autowired
    private BindedRecordMapper bindedRecordMapper;

    @Override
    public BindedRecordMapper getCrudRepository() {
        return bindedRecordMapper;
    }


    /**
     * 是否已经绑卡
     *
     * @param appId
     * @param accountId
     * @param bankcard
     * @return
     */
    public boolean hasBindedCard(String appId, String accountId, String bankcard) {
        BindedRecord bindedRecord = new BindedRecord();
        bindedRecord.setAppId(appId);
        bindedRecord.setBankcard(bankcard);
        bindedRecord.setAccountId(accountId);
        Optional<BindedRecord> optional = bindedRecordMapper.findOne(Example.of(bindedRecord));
        if (optional.isPresent()) {
            BindedRecord br = optional.get();
            if (br != null) {
                return true;
            }
        }
        return false;
    }
}
