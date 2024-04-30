package com.example.testingsp.Security;

import com.example.testingsp.Entite.UsersAuth;
import com.example.testingsp.Repository.UsersAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CsUserDetailsService implements UserDetailsService {


    @Autowired
    private UsersAuthRepo usersAuthRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UsersAuth> userOptional = usersAuthRepo.findByNom(username);

        UsersAuth user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));


        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }


}
