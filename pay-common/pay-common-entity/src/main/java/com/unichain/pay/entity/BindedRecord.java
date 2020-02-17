package com.unichain.pay.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/23/2019
 * @Description ${Description}
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class BindedRecord extends BaseEntity {
    // 绑卡四要素
    @Column(columnDefinition = "varchar(32) COMMENT '应用ID'")
    private String appId;
    @Column(columnDefinition = "bigint(20) COMMENT '通道ID'")
    private Long channelId;
    @Column(columnDefinition = "varchar(32) COMMENT '银行卡'")
    private String bankcard;

    @Column(columnDefinition = "varchar(32) COMMENT '账号ID'")
    private String accountId;
    @Column(columnDefinition = "varchar(32) COMMENT '用户名'")
    private String userName;
    @Column(columnDefinition = "varchar(32) COMMENT '手机号'")
    private String phone;
    @Column(columnDefinition = "varchar(32) COMMENT '银行code'")
    private String bankCode;
}
