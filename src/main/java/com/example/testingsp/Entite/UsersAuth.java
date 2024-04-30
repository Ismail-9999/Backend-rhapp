package com.example.testingsp.Entite;


import jakarta.persistence.*;
import lombok.Data;

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




}
