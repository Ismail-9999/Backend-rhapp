package com.example.testingsp.Repository;

import com.example.testingsp.Entite.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepo extends JpaRepository<Notes,Integer> {
}
