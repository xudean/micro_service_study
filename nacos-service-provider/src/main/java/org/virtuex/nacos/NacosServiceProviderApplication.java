/**  
 * @Title: NacosServiceProviderApplication.java
 * @version V1.0 
 * @Copyright: 2019 www.koal.com Inc. All rights reserved. 
 */
package org.virtuex.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: chenx
 * @date: 2019年10月17日
 * @Description: TODO(用一句话描述该文件做什么)
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosServiceProviderApplication.class, args);
	}
}
