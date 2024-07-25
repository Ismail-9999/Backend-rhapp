package com.example.testingsp.Entite;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;



@Entity
@Table(name = "commentaire")
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_commentaire;
    private String commentaire;
    @Column(name = "user_creation")
    private String userCreation;
    @Column(name = "date_creation")
    private Date dateCreation;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Jobs jobs;

    public Commentaire(int id_commentaire, String commentaire, String userCreation, Date dateCreation, Jobs jobs) {
        this.id_commentaire = id_commentaire;
        this.commentaire = commentaire;
        this.userCreation = userCreation;
        this.dateCreation = dateCreation;
        this.jobs = jobs;
    }

    public Commentaire(String commentaire, String userCreation, Date dateCreation, Jobs jobs) {
        this.commentaire = commentaire;
        this.userCreation = userCreation;
        this.dateCreation = dateCreation;
        this.jobs = jobs;
    }

    public Commentaire() {

    }

    public String getCommentaire() {return commentaire;}
    public void setCommentaire(String commentaire) {this.commentaire=commentaire;}

    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "id_commentaire=" + id_commentaire +
                "commentaire=" + commentaire +
                ", userCreation='" + userCreation + '\'' +
                ", dateCreation=" + dateCreation +
                ", jobs=" + jobs +
                '}';
    }
}
