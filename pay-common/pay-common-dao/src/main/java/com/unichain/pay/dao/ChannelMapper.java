package com.unichain.pay.dao;

import com.unichain.pay.entity.MerchantApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @since 2019-07-18
 */
@Repository
public interface ChannelMapper extends JpaRepository<MerchantApp, Long>, JpaSpecificationExecutor<MerchantApp>/*, BaseMapper<CompanyApp>*/ {

}
