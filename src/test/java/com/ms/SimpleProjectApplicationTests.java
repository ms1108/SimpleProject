package com.ms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SimpleProjectApplicationTests {
    @Lazy
    @Autowired
    private DataSource localDB;

    @Lazy
    @Autowired
    private DataSource localDB2;

    @Lazy
    @Autowired
    private DataSource localDB3;

    @Test
    void contextLoads() {
        System.out.println("1");
        String queryResult = new JdbcTemplate(localDB).queryForObject("select name from t_user where id=1 limit 1;", String.class);
        assertThat(queryResult).as("校验非空").isNotNull();

    }

    //@Test
    //void contextLoads2() {
    //    System.out.println("2");
    //    String queryResult = new JdbcTemplate(localDB2).queryForObject("select app_name from module_config where id=50 limit 1;", String.class);
    //    assertThat(queryResult).as("校验非空").isNotNull();
    //
    //}
    //@Test
    //void contextLoads3() {
    //    System.out.println("3");
    //    String queryResult = new JdbcTemplate(localDB3).queryForObject("select name from t_user where id=1 limit 1;", String.class);
    //    assertThat(queryResult).as("校验非空").isNotNull();
    //
    //}
}
