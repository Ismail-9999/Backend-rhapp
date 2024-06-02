package com.example.testingsp.Entite;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

@Table(name = "utulisateurs")
@Entity
@Data
public class UsersAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int user_id;
    public String username;
    public String email;
    public String password;
    public String roles;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateCreation;

    @CreatedBy
    private String userCreation;

    @PrePersist
    public void prePersist() {
        this.dateCreation = new Date();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        this.userCreation = username;
    }


}
