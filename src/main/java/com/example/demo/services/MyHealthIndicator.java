package com.example.demo.services;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

    private int counter = 0;

    @Override
    public Health health() {
        int errorCode;
        if (counter % 2 == 0)
            errorCode = 1;
        else
            errorCode = 0;
        counter++;
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

}