package com.unichain.pay.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * <p>
 * 公司及支付渠道对应关系
 * </p>
 *
 * @since 2019-07-09
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MerchantChannel extends BaseEntity {
    // 商户ID
    @Column(columnDefinition = "varchar(32) COMMENT '商户ID'")
    private Long merchantId;
    // 支付渠道ID
    @Column(columnDefinition = "bigint(20) COMMENT '通道ID'")
    private Long channelId;
    //商户编码
    @Column(columnDefinition = "varchar(32) COMMENT '商户码'")
    private String merchantCode;
    //支付渠道码
    @Column(columnDefinition = "varchar(32) COMMENT '通道码'")
    private String channelCode;

    // 商户号
    @Column(columnDefinition = "varchar(32) COMMENT '商户号'")
    private String merchantNo;
    //
    @Column(columnDefinition = "varchar(32) COMMENT '私钥'")
    private String privateKey;

    @Column(columnDefinition = "varchar(32) COMMENT '公钥'")
    private String publicKey;

    @Column(columnDefinition = "varchar(32) COMMENT '密钥'")
    private String secretKey;
}
