package com.unichain.pay.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author lait.zhang@gmail.com
 * @Tel 15801818092
 * @Date 12/23/2019
 * @Description ${Description}
 */
@Data
public class WithholdList {

    private String appId;
    private String channelId;

    private String accountId;
    private  String bankcard;
    private  String bankCode;



    private String userName;
    private String idcard;
    private String phone;

    // 金额
    private BigDecimal amount;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int state;
    private boolean deleted;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'", insertable = false)
    private Date ctime;
}
