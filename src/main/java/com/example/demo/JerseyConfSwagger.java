package com.example.demo;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class JerseyConfSwagger extends ResourceConfig {

    public JerseyConfSwagger() {

        register(RestApi.class);
        register(HelloController.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);

    }

    @PostConstruct
    public void init() {
        SwaggerConfig();
    }

    private void SwaggerConfig() {
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);
        register(RestApi.class);
        BeanConfig swaggerConfigBean = new BeanConfig();
        swaggerConfigBean.setTitle("Using Swagger ,Jersey And Spring Boot ");
        swaggerConfigBean.setVersion("v1");
        swaggerConfigBean.setContact("Itzik");
        swaggerConfigBean.setSchemes(new String[]{"http", "https"});
        swaggerConfigBean.setBasePath("/api");
        swaggerConfigBean.setResourcePackage("com.example.demo");
        swaggerConfigBean.setPrettyPrint(true);
        swaggerConfigBean.setScan(true);
    }

}
