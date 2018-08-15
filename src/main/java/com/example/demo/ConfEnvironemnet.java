package com.example.demo;

import org.springframework.core.env.ConfigurableEnvironment;

public class ConfEnvironemnet {

    private static ConfigurableEnvironment environment;

    public ConfEnvironemnet(ConfigurableEnvironment environment) {
        ConfEnvironemnet.environment = environment;
    }

    public static ConfigurableEnvironment getEnvironment() {
        return environment;
    }
}
