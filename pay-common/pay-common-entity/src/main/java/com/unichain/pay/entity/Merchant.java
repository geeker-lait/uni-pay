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
public class Merchant extends BaseEntity {

    @Column(columnDefinition = "varchar(32) COMMENT '商户名称'")
    private String merchantName;
    /**
     * 公司唯一标识
     */
    @Column(columnDefinition = "varchar(32) COMMENT '商户码'")
    private String merchantCode;

    @Column(columnDefinition = "varchar(32) COMMENT '商户号'")
    private String merchantNo;

    /**
     * 法人
     */
    @Column(columnDefinition = "varchar(32) COMMENT '法人'")
    private String legaler;

    /**
     * 联系方式
     */
    @Column(columnDefinition = "varchar(32) COMMENT '联系方式'")
    private String contact;
}
