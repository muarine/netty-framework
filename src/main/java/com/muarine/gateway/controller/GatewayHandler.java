/*
 * RT MAP, Home of Professional MAP
 * Copyright 2017 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.muarine.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author maoyun@rtmap.com
 * @project netty-framework
 * @package com.muarine.gateway.controller
 * @date 5/22/18
 */
@Component
public class GatewayHandler {

    private Logger LOGGER = LoggerFactory.getLogger(GatewayHandler.class);

    public Mono<ServerResponse> executeGateway(ServerRequest request){
        LOGGER.info("path:{}", request.path());
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(BodyInserters.fromObject("Hello World"));
    }
}
