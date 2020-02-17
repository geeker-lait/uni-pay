package com.unichain.pay.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Accessors(chain = true)
public class MerchantApp extends BaseEntity {
    /**
     * 公司ID
     */
    private Long merchantId;
    /**
     * 公司名称
     */
    private String merchantName;

    private String merchantCode;
    /**
     * 应用类型
     */
    private String appTyp;
    /**
     * 应用名
     */
    private String appName;
    /**
     * 应用码
     */
    private String appCode;

    private String appId;
}
