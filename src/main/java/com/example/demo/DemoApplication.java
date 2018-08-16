package com.example.demo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = new SpringApplicationBuilder(DemoApplication.class)
                .properties("spring.config.name:application",
                        "spring.config.location:/opt/conf/application.properties")
                .build()
                .run(args);
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        context.reset();
        Logger root = (Logger) LoggerFactory.getLogger(DemoApplication.class);
        String logLevel = configurableApplicationContext.getEnvironment().getProperty("LOGGING_LEVEL");
        root.setLevel(Level.toLevel(logLevel, Level.ERROR));
    }

}


