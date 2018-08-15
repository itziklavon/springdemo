package com.example.demo.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ConfigureProperties {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer pspc
                = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[ ]
                { new ClassPathResource( "/opt/conf/application.properties" ) };
        pspc.setLocations( resources );
        pspc.setIgnoreUnresolvablePlaceholders( true );
        return pspc;
    }

}
