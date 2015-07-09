/* 
 * RT MAP, Home of Professional MAP 
 * Copyright 2015 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.netty.muarine.dao;

import com.netty.muarine.entity.User;

public interface UserMapper {
	User selectUserByNameOrMobile(String username);
}
