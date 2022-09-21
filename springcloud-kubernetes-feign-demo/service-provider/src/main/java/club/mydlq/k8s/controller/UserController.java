package club.mydlq.k8s.controller;

import club.mydlq.feign.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@RestController
public class UserController implements TestInterface {

    @Autowired
    private Environment env;

    @Override
    public String getInfo() {
        return "Hello World!";
    }

    @Override
    public String getConsumerIp() throws UnknownHostException {

        return Inet4Address.getLocalHost().getHostAddress()+env.getProperty("MY_POD_NAME");
    }

}
