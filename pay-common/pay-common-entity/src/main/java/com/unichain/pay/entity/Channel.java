package com.unichain.pay.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

/**
 * <p>
 * 支付通道
 * </p>
 *
 * @since 2019-07-09
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Channel extends BaseEntity {

    /**
     * 通道编码
     */
    private String channelCode;

    /**
     * 通道名称
     */
    private String channelName;

    /**
     * 联系人
     */
    private String contacter;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 通道URL
     */
    private String url;


}
