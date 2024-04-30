package com.example.testingsp.Repository;

import com.example.testingsp.Entite.UsersAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersAuthRepo extends JpaRepository<UsersAuth, Integer> {


    @Query(value = "select * from utulisateurs where username=?1  " , nativeQuery = true)
    Optional<UsersAuth> findByNom(String username);


}
