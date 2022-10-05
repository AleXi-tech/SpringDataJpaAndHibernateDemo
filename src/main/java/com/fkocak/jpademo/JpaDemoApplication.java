package com.fkocak.jpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    //jdbc url has changed in the app.prop file toa fixed url and h2 console enabled
    //we created schema.sql file with a table in resources to reach it from localhost:8080/h2-console

}
