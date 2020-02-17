package com.unichain.pay.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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
public class PaymentList extends BaseEntity {


    private String appId;
    private Long channelId;

    private String accountId;
    private  String bankcard;
    private  String bankCode;



    private String userName;
    private String idcard;
    private String phone;

    // 金额
    private BigDecimal amount;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private int state;
//    private boolean deleted;
//    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'", insertable = false)
//    private Date ctime;
}
