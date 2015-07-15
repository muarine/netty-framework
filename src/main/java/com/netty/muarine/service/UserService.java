/* 
 * RT MAP, Home of Professional MAP 
 * Copyright 2015 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.netty.muarine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netty.muarine.dao.UserMapper;
import com.netty.muarine.entity.User;

/**
 * UserService.
 * 
 * @author Muarine maoyun@rtmap.com
 * @date 2015年7月15日
 * @since 2.0
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User select(String name){
		return userMapper.selectUserByNameOrMobile(name);
	}
	
}
