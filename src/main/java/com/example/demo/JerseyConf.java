package com.example.demo;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConf extends ResourceConfig {

    public JerseyConf() {

        register(RestApi.class);
        register(HelloController.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);

    }

}
