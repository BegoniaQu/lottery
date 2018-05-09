package com.homedo.as.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by quyang on 2018/3/28.
 */
@Configuration
@PropertySource("classpath:db.properties")
public class DataSourceConfig {

    @Bean(name="dataSource", destroyMethod = "close")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }


    @Primary
    @Bean(name = "txManager")
    public DataSourceTransactionManager getSvrTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
