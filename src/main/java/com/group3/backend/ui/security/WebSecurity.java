package com.group3.backend.ui.security;

import com.group3.backend.datasource.repos.UserRepository;
import com.group3.backend.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public WebSecurity(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    //method to allow certain API endpoints to be accessed without being logged in.
    //also activates the authentication filter which is what Spring boot uses to log users in and give them a JSON web token.
    // This token is how we know new requests coming in are from a particular user
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(req -> new CorsConfiguration().applyPermitDefaultValues()).and()
                .csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/users").permitAll().anyRequest().authenticated()
                .and()
                .addFilter(new AuthenticationFilter(authenticationManager(), userRepository))
                .addFilter(new AuthorisationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
    }

    //setting the encryption method for encrypting our password
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
