package com.example.testingsp.DTO;

import com.example.testingsp.Entite.Jobs;

import java.util.Date;

public class CommentaireSaveDTO {
    private String commentaire;
    private String userCreation;

    private Date dateCreation;
    private Jobs jobs;

    public CommentaireSaveDTO(String commentaire, String userCreation, Date dateCreation, Jobs jobs) {
        this.commentaire = commentaire;
        this.userCreation = userCreation;
        this.dateCreation = dateCreation;
        this.jobs = jobs;
    }

    public CommentaireSaveDTO() {
    }

    public String getCommentaire(){return commentaire;}
    public void setCommentaire(String commentaire){ this.commentaire= commentaire;}

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
        return "CommentaireSaveDTO{" +
                "commentaire=" + commentaire +
                "userCreation='" + userCreation + '\'' +
                ", dateCreation=" + dateCreation +
                ", jobs=" + jobs +
                '}';
    }
}
