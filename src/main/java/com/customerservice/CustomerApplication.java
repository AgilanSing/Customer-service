package com.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by IntelliJ IDEA.
 * Project : Customer Service
 * User: Agilan 
 * Email: agilan92@gmail.com
 */
@SpringBootApplication
@EnableJpaAuditing
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
