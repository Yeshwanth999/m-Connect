package com.adminservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class AdminserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminserviceApplication.class, args);
    }

    // Other application configuration and beans can be defined here
}





