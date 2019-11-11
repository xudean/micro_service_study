/**  
 * @Title: NacosServiceConsumerApplication.java
 * @version V1.0 
 * @Copyright: 2019 www.koal.com Inc. All rights reserved. 
 */
package org.virtuex.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: xuda.it@outlook.com
 * @date: 2019年11月10日
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosServiceConsumerApplication.class, args);
	}
}
