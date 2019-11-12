package org.virtuex.nacos.config;

import org.springframework.context.annotation.Bean;
import org.virtuex.nacos.service.impl.EchoServiceFallback;

/**
 * @author xuda
 * @email xuda@koal.com
 * @Description:
 * @date 2019/11/1 13:20
 */
public class FeignConfiguration {
    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }

}
