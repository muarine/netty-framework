/*
 * RT MAP, Home of Professional MAP
 * Copyright 2017 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.muarine.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author maoyun@rtmap.com
 * @project netty-framework
 * @package com.muarine.gateway
 * @date 5/22/18
 */
@SpringBootApplication
@MapperScan(basePackages = "com.muarine.gateway.dao")
@EnableTransactionManagement
public class ApiGatewayApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}

