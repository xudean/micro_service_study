package org.virtue.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该配置类为Feign的配置类
 * 注意：该类不应该在主类程序上下文的@CompanentScan中，否则该类的信息会被所有的FeignClient共享
 */
@Configuration
public class FeignConfiguration {
    /**
     * 将契约修改为Feign的默认契约。这样可以使用Feign自带的注解
     * @return 默认的Feign契约
     */
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
