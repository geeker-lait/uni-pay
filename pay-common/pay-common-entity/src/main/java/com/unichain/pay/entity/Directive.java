package com.unichain.pay.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * <p>
 * 指令
 * </p>
 *
 * @since 2019-07-09
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Directive extends BaseEntity {

    @Column(columnDefinition = "varchar(32) COMMENT ' 通道ID'")
    private Long channelId;

    @Column(columnDefinition = "varchar(32) COMMENT '通道CODE'")
    private String channelCode;

    @Column(columnDefinition = "varchar(32) COMMENT '指令编码'")
    private String code;

    @Column(columnDefinition = "varchar(32) COMMENT '指令名称'")
    private String name;

    @Column(columnDefinition = "varchar(32) COMMENT '指令的uri'")
    private String uri;

    @Column(columnDefinition = "varchar(32) COMMENT '回调地址'")
    private String callbackUrl;

    @Column(columnDefinition = "varchar(32) COMMENT '重定向地址'")
    private String redirectUrl;

    @Column(columnDefinition = "varchar(32) COMMENT '指令权重'")
    private Integer weight;

    @Column(columnDefinition = "varchar(32) COMMENT '指令描述'")
    private String descr;
}
