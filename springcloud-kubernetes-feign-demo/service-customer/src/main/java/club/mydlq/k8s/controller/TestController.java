package club.mydlq.k8s.controller;

import club.mydlq.k8s.feign.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.UnknownHostException;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/")
    public String getTestInfo(){
        return testService.getInfo();
    }

    @GetMapping("/ip")
    public String getConsumerIp() throws UnknownHostException {
        return testService.getConsumerIp();
    }

}
