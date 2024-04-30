package com.example.testingsp.Repository;

import com.example.testingsp.Entite.Consultant;
import com.example.testingsp.Entite.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepo  extends JpaRepository<Consultant,Integer> {
}
