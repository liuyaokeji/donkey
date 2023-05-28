package com.donkey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(value = "com.example.demo.management.mapper")
public class DonKeyApplication {
    public static void main(String[] args) {
        SpringApplication.run(DonKeyApplication.class, args);
    }
}
