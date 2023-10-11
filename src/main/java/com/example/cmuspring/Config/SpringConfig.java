package com.example.cmuspring.Config;

import com.example.cmuspring.Service.Impl.UserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import java.util.UUID;

import static com.example.cmuspring.Utils.Constants.Api;

@EnableWebSecurity
@Configuration
public class SpringConfig {

    private static final String[] MEDECIN = {Api + "/consulter", Api + "/modifier",Api + "/consultation"};
    private static final String[] EMPLOYER = {Api + "/creeDossier", Api + "/supprimer"};
    private static final String PATIENT = Api + "/voirConsultation";
    private static final String UTILISATEUR = Api + "/utilisateur";

    @Autowired
    public SpringConfig( UserDetailServiceImp userDetailServiceImp) {
        this.userDetailServiceImp = userDetailServiceImp;
    }

    UserDetailServiceImp userDetailServiceImp;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers(PATIENT).hasAuthority("PATIENT")
                        .requestMatchers(EMPLOYER).hasAuthority("EMPLOYER")
                        .requestMatchers(MEDECIN).hasAuthority("MEDECIN")
                        .requestMatchers(UTILISATEUR).permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .userDetailsService(userDetailServiceImp);

        return httpSecurity.build();
    }

}
