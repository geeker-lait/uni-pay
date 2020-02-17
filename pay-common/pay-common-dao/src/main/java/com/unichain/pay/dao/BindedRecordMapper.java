package com.unichain.pay.dao;

import com.unichain.pay.entity.BindedRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 2/17/2020
 * @Description ${Description}
 */
public interface BindedRecordMapper extends JpaRepository<BindedRecord, Long>, JpaSpecificationExecutor<BindedRecord> {
}
