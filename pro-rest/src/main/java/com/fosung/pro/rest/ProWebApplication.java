package com.fosung.pro.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProWebApplication {

    public static void main(String[] args){
       new SpringApplication(ProWebApplication.class).run(args);
    }

}
