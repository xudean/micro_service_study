/**  
 * @Title: NacosServiceConsumerApplication.java
 * @version V1.0 
 * @Copyright: 2019 www.koal.com Inc. All rights reserved. 
 */
package org.virtuex.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author:
 * @date: 2019年10月17日
 * @Description: TODO(用一句话描述该文件做什么)
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosServiceConsumerApplication {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(NacosServiceConsumerApplication.class, args);
	}
}
