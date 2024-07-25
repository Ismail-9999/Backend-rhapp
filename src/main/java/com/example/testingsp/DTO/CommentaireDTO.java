package com.example.testingsp.DTO;

import com.example.testingsp.Entite.Jobs;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

public class CommentaireDTO {

    private int id_commentaire;
    private String commentaire;

    private String userCreation;

    private Date dateCreation;
    private Jobs jobs;

    public CommentaireDTO(int id_commentaire, String commentaire, String userCreation, Date dateCreation, Jobs jobs) {
        this.id_commentaire = id_commentaire;
        this.commentaire = commentaire;
        this.userCreation = userCreation;
        this.dateCreation = dateCreation;
        this.jobs = jobs;
    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public String getCommentaire() {return commentaire;}
    public void setCommentaire(String commentaire){this.commentaire = commentaire;}
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
        return "CommentaireDTO{" +
                "id_commentaire=" + id_commentaire +
                "commentaire=" + commentaire +
                ", userCreation='" + userCreation + '\'' +
                ", dateCreation=" + dateCreation +
                ", jobs=" + jobs +
                '}';
    }
}
