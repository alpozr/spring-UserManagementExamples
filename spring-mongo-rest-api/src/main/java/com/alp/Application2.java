package com.alp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Application2 {
    public static void main(String[] args) {
        SpringApplication.run(Application2.class, args);
    }
}
