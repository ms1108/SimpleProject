package com.ms;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.sql.DataSource;

@Configuration
@Lazy
public class ConnectDB {

    @Bean
    public DataSource localDB(@Value("${mysql.local.url}") String url,
                                       @Value("${mysql.local.username}") String username,
                                       @Value("${mysql.local.password}") String password) {
        System.out.println("localDB1");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DataSource localDB2(@Value("${mysql.local2.url}") String url,
                              @Value("${mysql.local2.username}") String username,
                              @Value("${mysql.local2.password}") String password) {
        System.out.println("localDB2");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DataSource localDB3(@Value("${mysql.local.url}") String url,
                               @Value("${mysql.local.username}") String username,
                               @Value("${mysql.local.password}") String password) {
        System.out.println("localDB3");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
