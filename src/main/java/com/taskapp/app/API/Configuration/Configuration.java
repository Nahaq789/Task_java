package com.taskapp.app.API.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public ModelMapper _modelMapper() {
        return new ModelMapper();
    }
}
