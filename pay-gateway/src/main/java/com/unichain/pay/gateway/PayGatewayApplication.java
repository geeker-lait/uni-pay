package com.unichain.pay.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.unichain.pay", "com.unichain.service"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.unichain.pay.dao")
@EntityScan(basePackages = "com.unichain.pay.entity")
@EnableCaching
public class PayGatewayApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PayGatewayApplication.class, args);
        //SpringUtils.setApplicationContext(run);
    }
}


