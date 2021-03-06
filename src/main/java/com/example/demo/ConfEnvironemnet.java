package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({
        "classpath:application.properties",
        "file:/opt/conf/application.properties"
})
public class ConfEnvironemnet {

    @Autowired
    private Environment env;

    public String getProperty(String property) {
        return env.getProperty(property);
    }


}
