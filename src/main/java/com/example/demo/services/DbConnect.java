package com.example.demo.services;

import com.example.demo.ConfEnvironemnet;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
public class DbConnect {

    public static final String PRIMARY_DATASOURCE = "OneDS";
    public static final String SECONDARY_DATASOURCE = "AnotherDS";

    @Autowired
    private ConfEnvironemnet confEnvironemnet;

    @Bean(name = PRIMARY_DATASOURCE, destroyMethod = "")
    public DataSource firstDataSource() {
        HikariDataSource ds = new HikariDataSource();
        String url = confEnvironemnet.getProperty("app.datasource.first.jdbcUrl");
        String userName = confEnvironemnet.getProperty("app.datasource.first.username");
        String password = confEnvironemnet.getProperty("app.datasource.first.password");
        ds.setJdbcUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        ds.addDataSourceProperty("cachePrepStmts", "true");
        ds.addDataSourceProperty("prepStmtCacheSize", "250");
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds.setMaximumPoolSize(10);
        ds.setMinimumIdle(2);
        ds.setSchema("dev_bo");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setLeakDetectionThreshold(300000);
        ds.setAutoCommit(false);
        return ds;
    }

    @Bean(name = SECONDARY_DATASOURCE, destroyMethod = "")
    public DataSource secondDataSource() {
        HikariDataSource ds = new HikariDataSource();
        String url = confEnvironemnet.getProperty("app.datasource.second.jdbcUrl");
        String userName = confEnvironemnet.getProperty("app.datasource.second.username");
        String password = confEnvironemnet.getProperty("app.datasource.second.password");
        ds.setJdbcUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        ds.addDataSourceProperty("cachePrepStmts", "true");
        ds.addDataSourceProperty("prepStmtCacheSize", "250");
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds.setMaximumPoolSize(10);
        ds.setMinimumIdle(2);
        ds.setSchema("discovery");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setLeakDetectionThreshold(300000);
        ds.setAutoCommit(false);
        return ds;
    }


}
