package org.virtue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class HystrixTurbineServicedApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineServicedApplication.class, args);
    }

}
