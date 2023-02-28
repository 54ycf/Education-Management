package com.ecnu.office;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
//@MapperScan(basePackages = "com.ecnu.office.mapper")
public class OfficeApplication {
    public static void main(String[] args) {
        SpringApplication.run(OfficeApplication.class,args);
    }
}
