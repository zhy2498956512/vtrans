package com.example.vtrans;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@MapperScan("com.example.vtrans.dao")
@SpringBootApplication
public class VtransApplication {

    public static void main(String[] args) {
        SpringApplication.run(VtransApplication.class, args);
    }

}
