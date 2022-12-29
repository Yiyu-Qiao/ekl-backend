package de.han.ekl.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class EklSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityConfigure(HttpSecurity http) throws Exception {
        var rst = http.authorizeHttpRequests(request -> {
                    request.requestMatchers("/api/auth/login").permitAll();
                    request.requestMatchers("/api/**").authenticated();
                    request.anyRequest().permitAll();
                })
//                .formLogin(configurer -> {
//                    configurer.usernameParameter("user");
//                    configurer.passwordParameter("pwd");
////                    configurer.successForwardUrl("/api/user/123456789");
//                    configurer.loginPage("/login");
//                })
//                .httpBasic(Customizer.withDefaults())
                .csrf().disable()
                .build();
        return rst;
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("han")
                .password("{noop}12345")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("yu")
                .password("{noop}12345")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
