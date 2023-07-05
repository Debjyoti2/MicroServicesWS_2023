package com.apigateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingGlobalPreFilter implements GlobalFilter {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange,GatewayFilterChain chain) {
        log.info("Global Pre Filter executed");
        return chain.filter(exchange);
    }
}
