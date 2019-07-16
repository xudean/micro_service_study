package org.virtue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.virtue.feign.UserFeignClient;
import org.virtue.pojo.ServiceUser;

import java.util.List;

@Controller
public class MovieController {
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Bean
    @LoadBalanced
    RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private UserFeignClient userFeignClient;


    @ResponseBody
    @RequestMapping(value = "/movie/users", method = {RequestMethod.GET})
    public List<ServiceUser> listUsers(){
        return this.restTemplate.getForObject("http://micro-user-service/users",List.class);
    }

    @ResponseBody
    @RequestMapping(value = "/log-instalce", method = {RequestMethod.GET})
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("micro-user-service");
        logger.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }

    @ResponseBody
    @RequestMapping(value = "/movie/{id}", method = {RequestMethod.GET})
    public ServiceUser getUserByUserId(@PathVariable Long id){
        return userFeignClient.findById(id);
    }

}
