package com.example.testingsp.Repository;

import com.example.testingsp.Entite.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Integer> {
}
