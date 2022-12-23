package de.han.ekl.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class EklSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityConfigure(HttpSecurity http) throws Exception {
        var rst = http.authorizeHttpRequests(request -> {
                    request.requestMatchers("/api/**").authenticated();
                    request.anyRequest().denyAll();
                })
                .formLogin(Customizer.withDefaults())
                .build();
        return rst;
    }
}
