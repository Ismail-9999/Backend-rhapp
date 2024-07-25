package com.example.testingsp.Repository;

import com.example.testingsp.Entite.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepo extends JpaRepository<Commentaire,Integer> {
}
