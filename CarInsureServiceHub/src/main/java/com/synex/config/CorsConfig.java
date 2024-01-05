package com.synex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/autoPlan")
                .allowedOrigins("http://localhost:8282")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
                
                registry.addMapping("/Insureds")
                .allowedOrigins("http://localhost:8282")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
                
                registry.addMapping("/policies")
                .allowedOrigins("http://localhost:8282")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
                
                registry.addMapping("/documents")
                .allowedOrigins("http://localhost:8282")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
                
                registry.addMapping("/createClaim")
                .allowedOrigins("http://localhost:8282")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
                
                registry.addMapping("/Addresses")
                .allowedOrigins("http://localhost:8282")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
                
                registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("http://localhost:8282") // Add your frontend origin(s)
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
                
            }
        };
    }
}
