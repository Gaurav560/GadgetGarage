package com.unlogged.gadgetgarage;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class GadgetGarageApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void verifyModularity() {
        ApplicationModules.of(GadgetGarageApplication.class).verify();
    }

    @Test
    void generateDocumentation() {
        new Documenter(ApplicationModules.of(GadgetGarageApplication.class))
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }
}
