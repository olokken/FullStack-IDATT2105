package com.fullStack.Repository;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.fullStack")
public class SpringJdbcConfig {
    @Bean
    public DataSource mysqlDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://mysql.stud.ntnu.no:3306/haavarty_datab?useSSL=false");
        dataSource.setUsername("haavarty_user1");
        dataSource.setPassword("tussi28");

        return dataSource;
    }
}
