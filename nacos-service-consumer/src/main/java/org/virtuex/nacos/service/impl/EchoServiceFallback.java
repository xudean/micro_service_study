package org.virtuex.nacos.service.impl;

import org.springframework.web.bind.annotation.PathVariable;
import org.virtuex.nacos.service.EchoService;

/**
 * @author xuda
 * @email xuda@koal.com
 * @Description:
 * @date 2019/11/1 13:19
 */
public class EchoServiceFallback implements EchoService {

    @Override
    public String sayHi(@PathVariable("user") String user) {
        return "fallback";
    }

    @Override
    public String sayHiError(@PathVariable("user")String user) {
        return "服务器发生异常";
    }
}