package org.bobpark.restlgging;

import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import org.bobpark.restlgging.configure.RestLoggingAutoConfiguration;
import org.junit.jupiter.api.Test;

class RestLoggingSpringBootStarterApplicationTests {


    @Test
    void testAutoConfiguration() {

        ApplicationContextRunner runner =
            new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(RestLoggingAutoConfiguration.class));

        runner.run(context -> {

        });

    }



}
