package com.example.demo;

import com.example.demo.mapper.DiscoveryMapper;
import com.example.demo.mapper.GamesMapper;
import com.example.demo.services.DbConnect;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.inject.Named;
import javax.sql.DataSource;

@Configuration
public class MyBatisConfiguration {
    private static final String ONE_SESSION_FACTORY = "oneSessionFactory";
    private static final String ANOTHER_SESSION_FACTORY = "anotherSessionFactory";

    @Bean(name = ONE_SESSION_FACTORY, destroyMethod = "")
    @Primary
    public SqlSessionFactoryBean sqlSessionFactory(@Named(DbConnect.PRIMARY_DATASOURCE) final DataSource oneDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(oneDataSource);
        SqlSessionFactory sqlSessionFactory;
        sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().addMapper(GamesMapper.class);
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperFactoryBean<GamesMapper> gameMapper(@Named(ONE_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
        MapperFactoryBean<GamesMapper> factoryBean = new MapperFactoryBean<>(GamesMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }

    @Bean(name = ANOTHER_SESSION_FACTORY, destroyMethod = "")
    public SqlSessionFactoryBean censoSqlSessionFactory(@Named(DbConnect.SECONDARY_DATASOURCE) final DataSource anotherDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(anotherDataSource);
        final SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().addMapper(DiscoveryMapper.class);
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperFactoryBean<DiscoveryMapper> discoveryMApper(@Named(ANOTHER_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
        MapperFactoryBean<DiscoveryMapper> factoryBean = new MapperFactoryBean<>(DiscoveryMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        return factoryBean;
    }
}