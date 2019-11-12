/**
 * @Title: HelloProviderController.java
 * @version V1.0
 * @Copyright: 2019 www.koal.com Inc. All rights reserved.
 */
package org.virtuex.nacos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.virtuex.nacos.service.impl.HelloProviderServiceImpl;

/**
 * @author: chenx
 * @date: 2019年10月17日
 * @Description: TODO(用一句话描述该文件做什么)
 */
@RestController
public class HelloProviderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloProviderController.class);
    @Autowired
    HelloProviderServiceImpl helloServiceProviderService;

    @GetMapping("/sayHi/{user}")
    public String sayHi(@PathVariable("user") String user) {
        LOGGER.info("Ribbon load balance!");
        return helloServiceProviderService.sayHi(user);
    }

    @GetMapping("/sayHiError/{user}")
    public String sayHiError(@PathVariable("user") String user) {
      throw new RuntimeException("模拟服务调用失败");
    }
}
