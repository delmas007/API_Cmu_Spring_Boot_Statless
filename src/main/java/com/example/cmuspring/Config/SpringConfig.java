package com.example.cmuspring.Config;

import com.example.cmuspring.Service.Impl.UserDetailServiceImp;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.UUID;

import static com.example.cmuspring.Utils.Constants.Api;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SpringConfig {

    private static final String[] MEDECIN = {Api + "/consulter", Api + "/modifier",Api + "/consultation"};
    private static final String[] EMPLOYER = {Api + "/creeDossier", Api + "/supprimer"};
    private static final String PATIENT = Api + "/voirConsultation";
    private static final String[] PUBLIC = {"/swagger-ui/**",
            "/v2/api-docs",
            Api +"/connexion",
            Api + "/utilisateur",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**"};

//    @Autowired
//    public SpringConfig( UserDetailServiceImp userDetailServiceImp,PasswordEncoder passwordEncoder) {
//        this.userDetailServiceImp = userDetailServiceImp;
//        this.passwordEncoder = passwordEncoder;
//    }

    UserDetailServiceImp userDetailServiceImp;
    PasswordEncoder passwordEncoder;
    RsakeysConfig rsakeysConfig;

    @Bean
    AuthenticationManager authenticationManager(UserDetailsService userDetailsService){
        DaoAuthenticationProvider authProvier = new DaoAuthenticationProvider();
        authProvier.setPasswordEncoder(passwordEncoder);
        authProvier.setUserDetailsService(userDetailsService);
        return new ProviderManager(authProvier);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers(PATIENT).hasAuthority("SCOPE_PATIENT")
                        .requestMatchers(EMPLOYER).hasAuthority("SCOPE_EMPLOYER")
                        .requestMatchers(MEDECIN).hasAuthority("SCOPE_MEDECIN")
                        .requestMatchers(PUBLIC).permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
//                .cors(Customizer.withDefaults())
//                .csrf(Customizer.withDefaults())
                .sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oauth2->oauth2.jwt(Customizer.withDefaults()))
//                .httpBasic(Customizer.withDefaults())
                .userDetailsService(userDetailServiceImp);

        return httpSecurity.build();
    }

    @Bean
    JwtDecoder jwtDecoder(){
        return NimbusJwtDecoder.withPublicKey(rsakeysConfig.publicKey()).build();
    }
    @Bean
    JwtEncoder jwtEncoder(){
        JWK jwk= new RSAKey.Builder(rsakeysConfig.publicKey()).privateKey(rsakeysConfig.privateKey()).build();
        JWKSource<SecurityContext> jwkSource= new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwkSource);
    }

}
