/* 
 * RT MAP, Home of Professional MAP 
 * Copyright 2015 Bit Main Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 */
package com.netty.muarine.tomcat.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class SimplePOJOExample {
	public static void main(String[] args) throws Exception {
        PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:mysql://localhost:3306/mysql");
        p.setDriverClassName("com.mysql.jdbc.Driver");
        p.setUsername("root");
        p.setPassword("123456");
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
          "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
          "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);

        Connection con = null;
        try {
          con = datasource.getConnection();
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select * from user");
          int cnt = 1;
          while (rs.next()) {
              System.out.println((cnt++)+". Host:" +rs.getString("Host")+
                " User:"+rs.getString("User")+" Password:"+rs.getString("Password"));
          }
          rs.close();
          st.close();
        } finally {
          if (con!=null) try {con.close();}catch (Exception ignore) {}
        }
    }
}
