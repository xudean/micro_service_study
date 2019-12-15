package org.virtuex.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.virtuex.gateway.constant.FilterOrder;
import org.virtuex.gateway.constant.TokenConstant;
import org.virtuex.gateway.filter.base.BaseFilter;
import org.virtuex.gateway.props.AuthProperties;
import org.virtuex.gateway.provider.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 认证过滤器
 */

@Component
@AllArgsConstructor
public class AuthenticationFilter extends BaseFilter implements GlobalFilter, Ordered {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilter.class);
    @Autowired
    private AuthProperties authProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        if (isSkip(path)) {
            return chain.filter(exchange);
        }
        ServerHttpResponse resp = exchange.getResponse();
        String username = exchange.getRequest().getHeaders().getFirst(TokenConstant.USER_NAME);
        LOGGER.info("进入认证步骤");
        if (StringUtils.isBlank(username)) {
            return unAuth(resp, "认证失败，缺少用户名", HttpStatus.UNAUTHORIZED);
        }

        return chain.filter(exchange);
    }

    private boolean isSkip(String path) {
        //获取系统默认放行路径，不需要认证
        List<String> defaultSkipUrl = AuthProvider.getDefaultSkipUrl();
        //配置文件中的放行路径
        defaultSkipUrl.addAll(authProperties.getSkipUrl());
        return AuthProvider.getDefaultSkipUrl().stream().map(url -> url.replace(AuthProvider.TARGET, AuthProvider.REPLACEMENT)).anyMatch(path::contains);

    }


    /**
     * 数值越小，顺序越靠前
     *
     * @return
     */
    @Override
    public int getOrder() {
        return FilterOrder.FIRST;
    }

}