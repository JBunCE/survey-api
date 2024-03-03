package org.example.surveyapi.infraestructure.configurations.security;

import org.example.surveyapi.infraestructure.configurations.security.filters.JwtAuthorizationFilter;
import org.example.surveyapi.infraestructure.configurations.security.filters.authentication.UserAuthenticationFilter;
import org.example.surveyapi.infraestructure.configurations.jwt.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {


    @Autowired
    private SecretKey secretKey;

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private JwtAuthorizationFilter authorizationFilter;

    @Autowired
    private AuthenticationManager userAuthManager;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        UserAuthenticationFilter userAuthenticationFilter = new UserAuthenticationFilter(jwtConfig, secretKey);
        userAuthenticationFilter.setAuthenticationManager(userAuthManager);
        userAuthenticationFilter.setFilterProcessesUrl("/user/access");

        http.cors(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);
        http.exceptionHandling(exceptionHandling -> exceptionHandling
                .authenticationEntryPoint(authenticationEntryPoint)
        );
        http.sessionManagement(sessionManagement -> sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        /* FILTERS */
        http.addFilter(userAuthenticationFilter)
                .addFilterBefore(authorizationFilter, UserAuthenticationFilter.class);

        /* REQUEST AUTHORIZATION */
        http.authorizeHttpRequests(auth -> {
            //API-DOCS
            auth.requestMatchers("/**").permitAll();

            /*
            // GENERAL
            auth.requestMatchers("/token/**").permitAll();
            auth.requestMatchers("/actuator/health").permitAll();

            // USER
            auth.requestMatchers("/users/create").permitAll();
            auth.requestMatchers("/users/{id}").hasRole("USER");

             */
        });

        return http.httpBasic(Customizer.withDefaults()).build();
    }

}
