package com.quaint.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.quaint.blog.mapper")
public class QuaintblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuaintblogApplication.class, args);
    }

}

