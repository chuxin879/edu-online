package com.guodong.ossservice;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;




@EnableFeignClients
@ComponentScan("com.guodong")
//@MapperScan("")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OssAppliaction {
    public static void main(String[] args){
        SpringApplication.run(OssAppliaction.class, args);
    }
}


