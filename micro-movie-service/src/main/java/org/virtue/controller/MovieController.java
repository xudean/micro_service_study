package org.virtue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.virtue.pojo.ServiceUser;

import java.util.List;

@Controller
public class MovieController {

    @Bean
    RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }
    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping(value = "/movie/users", method = {RequestMethod.GET})
    public List<ServiceUser> listUsers(){
       return this.restTemplate.getForObject("http://127.0.0.1:8881/users",List.class);
    }
}
