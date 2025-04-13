package com.example.addressbook.security.config;

import com.example.addressbook.appuser.AppUserService;
//import com.example.addressbook.security.jwt.JwtRequestFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/api/v1/contacts/**").permitAll() // Allow access without auth
                        .requestMatchers("/api/v*/registration/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }
}

//    private final AppUserService appUserService;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
////    private final JwtRequestFilter jwtRequestFilter; // Inject JwtRequestFilter
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(CsrfConfigurer::disable)
//                .authorizeHttpRequests((authz) -> authz
//                        .requestMatchers("/api/v*/registration/**").permitAll()
//                        .requestMatchers("/api/v*/auth/**").permitAll() // Add auth endpoint (login)
//                        .anyRequest().authenticated()
//                )
//                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // Add JwtRequestFilter
////                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // Add JwtRequestFilter
//
//        return http.build();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider =
//                new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(bCryptPasswordEncoder);
//        provider.setUserDetailsService(appUserService);
//        return provider;
//    }
//}