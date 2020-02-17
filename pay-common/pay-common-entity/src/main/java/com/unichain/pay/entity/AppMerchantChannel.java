package com.unichain.pay.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AppMerchantChannel extends BaseEntity {

    /**
     * 应用ID
     */
    @Column(columnDefinition = "varchar(22) COMMENT '应用ID'")
    private String appId;

    @Column(columnDefinition = "varchar(22) COMMENT '商户ID'")
    private Long merchantId;

    @Column(columnDefinition = "bigint(21) COMMENT '通道ID'")
    private Long channelId;

    /**
     * 权重比
     */
    private Integer weight;


}
