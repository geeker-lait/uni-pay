package com.unichain.pay.admin.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.unichain.pay", "com.unichain.service"})
@EnableJpaRepositories(basePackages = "com.unichain.pay.dao")
@EntityScan(basePackages = "com.unichain.pay.entity")
@EnableTransactionManagement
@EnableEurekaClient
public class AdminPayApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminPayApplication.class, args);
    }
}
