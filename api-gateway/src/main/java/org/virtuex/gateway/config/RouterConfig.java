package org.virtuex.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuda
 * @email xuda@koal.com
 * @Description:网关路由，转到对应的微服务上
 * @date 2019/12/4 10:18
 */
@Configuration
public class RouterConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //服务路由
                .route("service_route", r -> r.path("/sayHi/*")
                        .uri("lb://nacos-provider-demo"))
                .build();
    }
}
