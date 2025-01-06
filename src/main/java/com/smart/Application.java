package com.smart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;

@SpringBootApplication
public class Application {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(Application.class, args);ad
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}