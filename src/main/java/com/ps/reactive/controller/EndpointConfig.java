package com.ps.reactive.controller;

import com.ps.reactive.order.OrderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EndpointConfig {
    private static final String ORDER = "/orders";

    @Bean
    RouterFunction<ServerResponse> routes(OrderHandler handler) {
        return route(GET(ORDER), handler::all)
                .andRoute(POST(ORDER), handler::create)
                .andRoute(DELETE(ORDER + "/{id}"), handler::deleteById)
                .andRoute(GET(ORDER + "/{id}"), handler::getById);
    }
}
