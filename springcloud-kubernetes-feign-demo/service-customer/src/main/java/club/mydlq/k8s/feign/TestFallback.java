package club.mydlq.k8s.feign;

import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Component
public class TestFallback implements TestService {

    @Override
    public String getInfo() {
        return "fallback!";
    }

    @Override
    public String getConsumerIp() throws UnknownHostException {
        return null;
    }

}