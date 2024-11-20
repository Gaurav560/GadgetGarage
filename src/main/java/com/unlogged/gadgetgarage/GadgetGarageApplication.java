package com.unlogged.gadgetgarage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulith;

@SpringBootApplication
@Modulith
public class GadgetGarageApplication {

    public static void main(String[] args) {
        SpringApplication.run(GadgetGarageApplication.class, args);
    }

}
