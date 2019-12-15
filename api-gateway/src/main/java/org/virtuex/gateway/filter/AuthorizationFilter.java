//package org.virtuex.gateway.filter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.virtuex.gateway.cache.PathInfoCache;
//import org.virtuex.gateway.constant.AclConstant;
//import org.virtuex.gateway.constant.FilterOrder;
//import org.virtuex.gateway.filter.base.BaseFilter;
//import org.virtuex.gateway.utils.AclHelper;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @author xuda
// * @email xuda@koal.com
// * @Description: 鉴权过滤器
// * @date 2019/12/4 10:26
// */
//@Slf4j
//@Component
//@AllArgsConstructor
//public class AuthorizationFilter extends BaseFilter implements GlobalFilter, Ordered {
//    private ObjectMapper objectMapper;
//    /**
//     * 这里对接口进行鉴权：
//     * 1.配置文件保存接口信息，包含：接口ID，资源路径，HttpMethod ，具体格式可见path_info.json
//     * 2.用户权限存储在用户表的ACL_VALUE字段中，计算方式是使用大数运算。权限值怎么获取待定，可有两种方式：1.从admin获取。2.如果使用JWT，可将用户权限值放入JWT中
//     * 3.鉴权时根据请求信息从本地配置文件读取到接口的ID，结合用户的ACL_VALUE字段可判断有无权限
//     * 权限计算与鉴权参考{@link AclHelper}
//     * @param exchange
//     * @param chain
//     * @return
//     */
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        //aclValue获取方式见方法说明
//        //这里先写个10,10由ID1,3计算而来
//        int aclValue = 10;
//        if(AclConstant.HEIGHTEST_LEVEL_ACL_VALUE==aclValue){
//            //拥有所有接口的调用权限，直接跳过
//            return chain.filter(exchange);
//        }
//        String path = request.getURI().getPath();
//        String methodValue = request.getMethodValue();
//        ServerHttpResponse resp = exchange.getResponse();
//        if(!hasRight(methodValue, path ,aclValue)){
//            resp.setStatusCode(HttpStatus.FORBIDDEN);
//            return unAuth(resp, "无该接口权限",HttpStatus.FORBIDDEN);
//        }
//        log.info("有权限操作该接口");
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return FilterOrder.SECOND;
//    }
//
//    private boolean hasRight(String methodValue,String path,int aclValue){
//        return PathInfoCache.getInstance().checkPath(methodValue, path ,aclValue);
//    }
//}
