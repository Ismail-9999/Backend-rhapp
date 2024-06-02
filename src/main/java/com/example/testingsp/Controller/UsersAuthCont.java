package com.example.testingsp.Controller;


import com.example.testingsp.Entite.UsersAuth;
import com.example.testingsp.Repository.UsersAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://i-team.ma","http://localhost:4200"})
@RequestMapping("/api")
public class UsersAuthCont {


    @Autowired
    private UsersAuthRepo usersAuthRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping(path = "/ct/user")
    public ResponseEntity<UsersAuth> addUser(@RequestBody UsersAuth usersAuth) {
        String encodedPassword = passwordEncoder.encode(usersAuth.getPassword());
        usersAuth.setPassword(encodedPassword);
        //Obtention du nom de l'utilisateur authentifié
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        usersAuth.setUserCreation(username);

        UsersAuth saveuser = usersAuthRepo.save(usersAuth);
        return new ResponseEntity<>(saveuser, HttpStatus.CREATED);

    }
}


