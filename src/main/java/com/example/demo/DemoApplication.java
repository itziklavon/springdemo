package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(DemoApplication.class)
//                .properties("spring.config.name:application",
//                        "spring.config.location:/opt/conf/application.properties")
                .build()
                .run(args);
    }

}


