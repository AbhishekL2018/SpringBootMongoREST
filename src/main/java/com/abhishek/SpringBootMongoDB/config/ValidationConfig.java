package com.abhishek.SpringBootMongoDB.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {

    @Bean
    public ValidatingMongoEventListener validationMongoEventListener(){
        return new ValidatingMongoEventListener(validation());
    }
    @Bean
    public LocalValidatorFactoryBean validation(){
        return new LocalValidatorFactoryBean();
    }
}
