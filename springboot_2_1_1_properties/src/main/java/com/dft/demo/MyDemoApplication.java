package com.dft.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyDemoApplication {

    public static void main(String[] args) {
//        SpringApplication.setAddCommandLineProperties(false);
        SpringApplication.run(MyDemoApplication.class, args);
    }
}
