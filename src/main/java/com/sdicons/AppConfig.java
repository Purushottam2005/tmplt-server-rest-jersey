package com.sdicons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// This class replaces a typical Spring configuration file.
// The @Bean methods each produce a <bean> instance, the name and type are derived from the method declaration.

@Configuration
public class AppConfig {

    // Simple String resource to test if injection really works.

    @Bean
    String messageTemplate() {
        return "REST Service - Hello %s!";
    }
}
