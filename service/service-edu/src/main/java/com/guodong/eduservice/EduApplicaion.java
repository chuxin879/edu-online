package com.guodong.eduservice;





import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;



@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.guodong"}) //配置扫描的注解
@MapperScan("com.guodong.eduservice.mapper")
public class EduApplicaion {
    public static void main(String[] args){
        SpringApplication.run(EduApplicaion.class, args);
    }



}
