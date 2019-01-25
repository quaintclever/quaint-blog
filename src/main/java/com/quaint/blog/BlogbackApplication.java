package com.quaint.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.quaint.blog.dao")
public class BlogbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogbackApplication.class, args);
    }

}

