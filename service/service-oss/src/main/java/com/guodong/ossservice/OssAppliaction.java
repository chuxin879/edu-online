package com.guodong.ossservice;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.guodong")
@MapperScan("")
public class OssAppliaction {
    public static void main(String[] args){
        SpringApplication.run(OssAppliaction.class, args);
    }
}
