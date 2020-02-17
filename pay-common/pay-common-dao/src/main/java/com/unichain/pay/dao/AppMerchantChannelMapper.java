package com.unichain.pay.dao;

import com.unichain.pay.entity.AppMerchantChannel;
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
public interface AppMerchantChannelMapper extends JpaRepository<AppMerchantChannel, Long>, JpaSpecificationExecutor<AppMerchantChannel>/*,BaseMapper<AppMerchantChannel>*/ {

}
