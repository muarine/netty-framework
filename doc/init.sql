CREATE TABLE `u_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `authorizer_id` bigint(11) NOT NULL COMMENT '授权方ID',
  `appid` varchar(50) NOT NULL COMMENT 'APPID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `nickname` varchar(50) DEFAULT NULL,
  `password` varchar(50) NOT NULL COMMENT '密码',
  `access_token` varchar(255) DEFAULT NULL,
  `salting` varchar(10) NOT NULL COMMENT '加盐值',
  `secret` varchar(50) DEFAULT NULL COMMENT '密钥',
  `expire_in` int(11) NOT NULL DEFAULT '2' COMMENT '过期时间(小时)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';