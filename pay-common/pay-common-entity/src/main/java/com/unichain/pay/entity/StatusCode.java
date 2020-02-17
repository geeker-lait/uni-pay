package com.unichain.pay.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 2/13/2020
 * @Description ${Description}
 */
@Entity
@Data
@Accessors(chain = true)
public class StatusCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long channelId;
    private String channelCode;

    private String code;
    private String descr;
    private String channelStateCode;
    private String channelStateDescr;
}
