package com.martinvana.censorship;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.zalando.problem.spring.web.autoconfigure.security.SecurityConfiguration;

/**
 * Main class.
 */
@EnableScheduling
@SpringBootApplication(
        exclude = {
                ErrorMvcAutoConfiguration.class,
                SecurityConfiguration.class // Turn off default security configuration for RFC 7807
        }
)
public class Application {

    /**
     * Main method.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .run(args);
    }
}
