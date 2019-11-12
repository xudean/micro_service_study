/**  
 * @Title: HelloProviderController.java
 * @version V1.0 
 * @Copyright: 2019 www.koal.com Inc. All rights reserved. 
 */
package org.virtuex.nacos.contraller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.virtuex.nacos.service.EchoService;

/**
 * @date: 2019年11月1日
 * @Description:
 */
@RestController
@Slf4j
public class SayHiConsumerController {

    @Autowired
    private EchoService echoService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/helloError/{user}")
    public String sayHiError(@PathVariable("user") String user) {
        return echoService.sayHiError(user);
    }

    @GetMapping("/hello/{user}")
    public String sayHi(@PathVariable("user") String user) {
        return echoService.sayHi(user);
    }

    @GetMapping("/hello-rest/{user}")
    public String rest(@PathVariable("user") String user) {
        return restTemplate.getForObject("http://nacos-provider-demo-xuda/sayHi/" + user,
                String.class);
    }
}
