package com.example.testingsp.Entite;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "notes")
public class Notes {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_note;
    @ManyToOne
    @JoinColumn(name = "id_jobs")
    private Jobs jobs;
    private String note;
    private String note_type;
    private Date dateCreation;
    private String userCreation;
    private String userModification;
    private Date dateModification;
}
