package com.authority.security.password;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PasswordApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasswordApplication.class, args);
    }

}
