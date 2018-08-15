package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    private static Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(DemoApplication.class)
//                .properties("spring.config.name:application",
//                        "spring.config.location:/opt/conf/application.properties")
                .build().run(args);

        new ConfEnvironemnet(applicationContext.getEnvironment());
        LOG.info(ConfEnvironemnet.getEnvironment().getProperty("server.port"));

    }


}


