package org.virtue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class MicroEurekaServerMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroEurekaServerMasterApplication.class, args);
    }

}
