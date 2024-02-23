package com.cloud.gateway.filter;


import com.cloud.gateway.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;


@Configuration
@Slf4j
public class AccessGatewayFilter implements GlobalFilter {

    @Lazy
    @Autowired
    private UserService userService;


    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain chain) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> userService.test());
        String user = future.join();
        log.info("user-{}", user);
        return chain.filter(serverWebExchange);
    }


}
