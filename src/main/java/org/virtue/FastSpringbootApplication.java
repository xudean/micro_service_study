package org.virtue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FastSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(FastSpringbootApplication.class, args);
    }
}
