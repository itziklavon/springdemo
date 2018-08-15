package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(DemoApplication.class)
                .properties("spring.config.name:application",
                        "spring.config.location:/opt/conf/application.properties")
                .build()
                .run(args);
    }

}


