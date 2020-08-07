package com.xss.libraryfinal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xss.libraryfinal.mapper")
public class LibraryfinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryfinalApplication.class, args);
    }

}
