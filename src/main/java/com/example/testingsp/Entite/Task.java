package com.example.testingsp.Entite;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="task")
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_task;
    private String task;
    @ManyToOne
    @JoinColumn(name = "id_jobs")
    private Jobs jobs;

    private String description;
    private String reminder;
    private String collab;
    private Date dateCreation;
    private String userCreation;
    private String userModification;
    private Date dateModification;


}
