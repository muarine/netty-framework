/*
 * RT MAP, Home of Professional MAP
 * Copyright 2017 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.muarine.gateway.router;

import com.muarine.gateway.controller.GatewayHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author maoyun@rtmap.com
 * @project netty-framework
 * @package com.muarine.gateway.router
 * @date 5/22/18
 */
@Configuration
public class GatewayRouter {

    @Bean
    public RouterFunction<ServerResponse> routeCity(GatewayHandler gatewayHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), gatewayHandler::executeGateway);
    }

}
