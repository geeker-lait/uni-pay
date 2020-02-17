package com.unichain.pay.dao;

import com.unichain.pay.entity.MerchantChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 公司及支付渠道对应关系 Mapper 接口
 * </p>
 *
 * @since 2019-07-09
 */
@Repository
public interface MerchantChannelMapper extends JpaRepository<MerchantChannel, Long>, JpaSpecificationExecutor<MerchantChannel>/*, BaseMapper<CompanyChannel>*/ {

}
