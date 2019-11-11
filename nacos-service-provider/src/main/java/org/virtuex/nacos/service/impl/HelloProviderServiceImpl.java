package org.virtuex.nacos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;

import org.virtuex.nacos.service.HelloProviderService;

@Service
public class HelloProviderServiceImpl implements HelloProviderService {

    @Autowired
    private ConfigurableEnvironment configurableEnvironment;

    @Override
    public String sayHi() {
        return "Hello Nacos, My Service Port is: " + configurableEnvironment.getProperty("server.port");
    }
}
