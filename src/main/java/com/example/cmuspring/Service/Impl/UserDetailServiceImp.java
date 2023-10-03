package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Dto.UtilisateurDto;
import com.example.cmuspring.Model.Utilisateur;
import com.example.cmuspring.Service.UtilisateurService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {

    UtilisateurServiceImp utilisateurServiceImp;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UtilisateurDto utilisateur = userDetailServiceImp.loadUserByUsername(username);
        UtilisateurDto utilisateur = utilisateurServiceImp.loadUserById(username);
        if(username==null) throw new UsernameNotFoundException("pas D'utilisateur");
        String authorities = utilisateur.getRole().getRole();
        UserDetails userDetails = User
                .withUsername(utilisateur.getId())
                .password(utilisateur.getPassword())
                .authorities(authorities)
                .build();
        return userDetails;
    }

}
