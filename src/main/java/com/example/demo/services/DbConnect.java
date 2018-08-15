package com.example.demo.services;

import com.example.demo.ConfEnvironemnet;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConnect {

    public static final String PRIMARY_DATASOURCE = "OneDS";
    public static final String SECONDARY_DATASOURCE = "AnotherDS";

    @Bean(name = PRIMARY_DATASOURCE, destroyMethod = "")
    @ConfigurationProperties(prefix = "app.datasource.first")
    public DataSource firstDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:mysql://" + "172.17.30.17" +
                ":" + "3306" + "/" + "dev_bo" + "?zeroDateTimeBehavior=convertToNull");
        ds.setUsername("root");
        ds.setPassword("123123");
        ds.addDataSourceProperty("cachePrepStmts", "true");
        ds.addDataSourceProperty("prepStmtCacheSize", "250");
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds.setMaximumPoolSize(10);
        ds.setMinimumIdle(2);
        ds.setSchema("dev_bo");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setLeakDetectionThreshold(300000);
        ds.setAutoCommit(false);
        return ds;
    }

    @Bean(name = SECONDARY_DATASOURCE, destroyMethod = "")
    @ConfigurationProperties(prefix = "app.datasource.second")
    public DataSource secondDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:mysql://" + "172.16.20.176" +
                ":" + "3306" + "/" + "discovery" + "?zeroDateTimeBehavior=convertToNull");
        ds.setUsername("root");
        ds.setPassword("123123");
        ds.addDataSourceProperty("cachePrepStmts", "true");
        ds.addDataSourceProperty("prepStmtCacheSize", "250");
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds.setMaximumPoolSize(10);
        ds.setMinimumIdle(2);
        ds.setSchema("discovery");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setLeakDetectionThreshold(300000);
        ds.setAutoCommit(false);
        return ds;
    }


}
