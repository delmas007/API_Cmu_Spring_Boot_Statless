package com.example.cmuspring.Config;

import com.example.cmuspring.Service.Impl.UserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.UUID;

import static com.example.cmuspring.Utils.Constants.Api;

@EnableWebSecurity
@Configuration
public class SpringConfig {

    @Autowired
    public SpringConfig( UserDetailServiceImp userDetailServiceImp) {
        this.userDetailServiceImp = userDetailServiceImp;
    }

    UserDetailServiceImp userDetailServiceImp;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/utilisation/").permitAll()
                        .requestMatchers("/a/").permitAll()
                        .requestMatchers(Api+"/consultation/**").hasAuthority("MEDECIN")
                        .requestMatchers(Api+"/voirConsultation/**").hasAuthority("PATIENT")
                        .requestMatchers(Api+"/creeDossier/**").hasAuthority("EMPLOYER")
                        .requestMatchers(Api+"/consulter/**").hasAuthority("MEDECIN")
                        .requestMatchers(Api+"/modifier/**").hasAuthority("MEDECIN")
                        .requestMatchers(Api+"/supprimer/**").hasAuthority("EMPLOYER")
                        .anyRequest()
                        .authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .userDetailsService(userDetailServiceImp);

        return httpSecurity.build();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder().encode("user"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }

}
