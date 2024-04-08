package com.test.api.internal.jsonapi.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.test.api.internal.jsonapi.server.dummy.DataLoader;

@Configuration
@SpringBootApplication
@Import({DataLoader.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
