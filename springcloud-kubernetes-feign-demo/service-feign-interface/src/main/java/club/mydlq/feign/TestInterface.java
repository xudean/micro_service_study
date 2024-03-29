package club.mydlq.feign;

import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;

public interface TestInterface {

    /**
     * 获取测试信息
     * @return
     */
    @GetMapping("/")
    public String getInfo();

    @GetMapping("/ip")
    String getConsumerIp() throws UnknownHostException;

}
