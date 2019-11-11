/**  
 * @Title: Config.java
 * @version V1.0 
 * @Copyright: 2019 www.koal.com Inc. All rights reserved. 
 */
package org.virtuex.nacos.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: xuda.it@outlook.com
 * @date: 2019年11月10日
 * @Description:
 */
@Configuration
public class Config {

	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
}
