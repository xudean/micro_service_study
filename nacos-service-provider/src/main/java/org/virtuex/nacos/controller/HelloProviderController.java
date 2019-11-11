/**
 * @Title: HelloProviderController.java
 * @version V1.0
 * @Copyright: 2019 www.koal.com Inc. All rights reserved.
 */
package org.virtuex.nacos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.virtuex.nacos.service.impl.HelloProviderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xuda.it@outlook.com
 * @date: 2019年11月10日
 * @Description:
 */
@RestController
public class HelloProviderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloProviderController.class);
    @Autowired
    HelloProviderServiceImpl helloServiceProviderService;

    @GetMapping("/sayHi")
    //对任何需要追踪的方法，使用 @Trace 标注，则此方法会被加入到追踪链中。
    @Trace()
    public String sayHi() {
        LOGGER.info("调用服务提供者");
        return helloServiceProviderService.sayHi();
    }
}
