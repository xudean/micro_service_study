package org.virtue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.virtue.mapper")
public class FastSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastSpringbootApplication.class, args);
    }

}
