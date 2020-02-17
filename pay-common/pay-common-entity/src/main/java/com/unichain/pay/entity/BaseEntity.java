package com.unichain.pay.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 基础父类测试
 * </p>
 */
@Data
@Accessors(chain = true)
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer state;
    private Boolean deleted;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'", insertable = false)
    private Date ctime;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间'", updatable = false)
    private Date utime;

}
