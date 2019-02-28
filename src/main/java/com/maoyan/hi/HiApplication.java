package com.maoyan.hi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.maoyan.hi.mapper")
public class HiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiApplication.class, args);
    }
}

