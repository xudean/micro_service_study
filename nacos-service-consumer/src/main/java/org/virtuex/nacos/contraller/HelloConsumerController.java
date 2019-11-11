/**  
 * @Title: HelloProviderController.java
 * @version V1.0 
 * @Copyright: 2019 www.koal.com Inc. All rights reserved. 
 */
package org.virtuex.nacos.contraller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: xuda.it@outlook.com
 * @date: 2019年11月10日
 * @Description:
 */
@RestController
public class HelloConsumerController {

    @Autowired
    private RestTemplate restTemplate;
	
	@GetMapping("/sayHi")
    public String sayHi() {
        String url = String.format("http://nacos-provider/sayHi");
        System.out.println("request url:" + url);
        return restTemplate.getForObject(url, String.class);
    }
}
