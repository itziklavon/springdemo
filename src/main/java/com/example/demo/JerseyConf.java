//package com.example.demo;
//
//import io.swagger.jaxrs.config.BeanConfig;
//import io.swagger.jaxrs.listing.ApiListingResource;
//import io.swagger.jaxrs.listing.SwaggerSerializers;
//import org.glassfish.jersey.server.ResourceConfig;
//import org.glassfish.jersey.servlet.ServletProperties;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PostConstruct;
//import javax.ws.rs.ApplicationPath;
//
//@Configuration
//public class JerseyConf extends ResourceConfig {
//
//    public JerseyConf() {
//
//        register(RestApi.class);
//        register(HelloController.class);
//        property(ServletProperties.FILTER_FORWARD_ON_404, true);
//
//    }
//}
