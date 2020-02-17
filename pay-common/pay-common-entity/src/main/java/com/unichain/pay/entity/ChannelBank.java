package com.unichain.pay.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/2/2019
 * @Description ${Description}
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ChannelBank extends BaseEntity {

    @Column(columnDefinition = "varchar(32) COMMENT '支付通道ID'")
    private Long channelId;
    @Column(columnDefinition = "varchar(32) COMMENT '支付通道码'")
    private String channelCode;
    @Column(columnDefinition = "varchar(32) COMMENT '支持银行名称'")
    private String bankName;
    @Column(columnDefinition = "varchar(32) COMMENT '支持银行码'")
    private String bankCode;
    @Column(columnDefinition = "int(3) DEFAULT 0 COMMENT '权重'")
    private Integer weight;
}
