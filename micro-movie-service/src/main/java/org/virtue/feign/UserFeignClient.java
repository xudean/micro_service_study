package org.virtue.feign;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.virtue.config.FeignConfiguration;
import org.virtue.pojo.ServiceUser;

//@FeignClient(name = "micro-user-service")
//public interface UserFeignClient {
//
//    /**
//     * 根据ID获取用户信息
//     */
//    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
//    ServiceUser findById(@PathVariable(value = "id") Long id);
//}
/**
 * 使用@FignClient的configuration属性，指定feign的配置类
 */
@FeignClient(name = "micro-user-service",configuration = FeignConfiguration.class)
public interface UserFeignClient{

    /**
     * 根据ID获取用户信息
     */
    @RequestLine("GET /users/{id}")
    ServiceUser findById(@Param("id") Long id);

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    ServiceUser findUserByIdAndUsername(@RequestParam("id") Long id,@RequestParam("username") String suername);
}