package org.virtuex.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.virtuex.nacos.config.FeignConfiguration;
import org.virtuex.nacos.service.impl.EchoServiceFallback;

/**
 * @author xuda
 * @email xuda@koal.com
 * @Description:
 * @date 2019/11/1 13:17
 */
@FeignClient(name = "nacos-provider-demo-xuda", fallback = EchoServiceFallback.class,
        configuration = FeignConfiguration.class)
public interface EchoService {

    @GetMapping("/sayHi/{user}")
    String sayHi(@PathVariable("user") String user);

    @GetMapping("/sayHiError/{user}")
    String sayHiError(@PathVariable("user") String user);
}
