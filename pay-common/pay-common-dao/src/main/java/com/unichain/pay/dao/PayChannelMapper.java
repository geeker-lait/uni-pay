package com.unichain.pay.dao;

import com.unichain.pay.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 支付通道 Mapper 接口
 * </p>
 *
 * @since 2019-07-09
 */
@Repository
public interface PayChannelMapper extends JpaRepository<Channel, Long>, JpaSpecificationExecutor<Channel>/*,BaseMapper<Channel> */ {

}
