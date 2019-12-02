package com.caacet.wll;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = {"com.caacet.wll"})
@MapperScan(basePackages = "com.caacet.wll.dao")
@EnableTransactionManagement
@EnableScheduling
public class AccountBookApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AccountBookApplication.class,args);
    }
}
