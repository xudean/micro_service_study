package org.virtue.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
import org.virtue.basic.result.BizResult;
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
    @HystrixCommand(fallbackMethod = "getUserFallBackByUserId")
    @RequestMapping(value = "/movie/{id}", method = {RequestMethod.GET})
    public BizResult getUserByUserId(@PathVariable Long id){
        ServiceUser user = userFeignClient.findById(id);
        BizResult bizResult = BizResult.success();
        bizResult.setMessage("查询成功");
        bizResult.setData(user);
        return bizResult;
    }

    public BizResult getUserFallBackByUserId(Long id){
        BizResult bizResult = new BizResult();
        bizResult.setMessage(String.format("获取id为%d的用户失败",id));
        bizResult.setRetCode(-1);
        return bizResult;
    }

}
