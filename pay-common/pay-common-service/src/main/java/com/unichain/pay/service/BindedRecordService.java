package com.unichain.pay.service;

import com.unichain.framework.common.CrudService;
import com.unichain.pay.dao.BindedRecordMapper;
import com.unichain.pay.entity.BindedRecord;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 2/16/2020
 * @Description ${Description}
 */
public interface BindedRecordService  extends CrudService<BindedRecord, BindedRecordMapper> {


   boolean hasBindedCard(String appId, String accountId,String bankcard);
}
