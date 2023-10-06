package com.takeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryECommerceApplication.class, args);
    }

}
