package org.virtuex.gateway.filter.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.virtuex.gateway.provider.ResponseProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author xuda
 * @email xuda@koal.com
 * @Description:
 * @date 2019/12/4 17:41
 */
@Slf4j
public abstract class BaseFilter {
    @Autowired
    private ObjectMapper objectMapper;

    public Mono<Void> unAuth(ServerHttpResponse resp, String msg, HttpStatus httpStatus) {
        resp.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        resp.setStatusCode(httpStatus);
        String result = "";
        try {
            result = objectMapper.writeValueAsString(ResponseProvider.unAuth(msg,httpStatus));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        DataBuffer buffer = resp.bufferFactory().wrap(result.getBytes(StandardCharsets.UTF_8));
        return resp.writeWith(Flux.just(buffer));
    }

}
