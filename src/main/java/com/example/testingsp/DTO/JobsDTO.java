package com.example.testingsp.DTO;

import com.example.testingsp.Entite.Commentaire;
import com.example.testingsp.Entite.Prospect;

import java.util.Date;
import java.util.List;

public class JobsDTO {
    private int id_jobs;
    private String nom_job;
    private String description_job;
    private Date dateCreation;
    private Date deadline;
    private String priorite;
    private String status;
    private String userCreation;
    private String mot_cle;
    private String canal;
    private String secteur_opportunite;
    private List<Commentaire> commentaires;
    private List<Prospect> prospects;

    public JobsDTO(int id_jobs, String nom_job, String description_job, Date dateCreation, Date deadline, String priorite, String status, String userCreation, String mot_cle, String canal, String secteur_opportunite, List<Commentaire> commentaires, List<Prospect> prospects) {
        this.id_jobs = id_jobs;
        this.nom_job = nom_job;
        this.description_job = description_job;
        this.dateCreation = dateCreation;
        this.deadline = deadline;
        this.priorite = priorite;
        this.status = status;
        this.userCreation = userCreation;
        this.mot_cle = mot_cle;
        this.canal = canal;
        this.secteur_opportunite = secteur_opportunite;
        this.commentaires = commentaires;
        this.prospects = prospects;
    }

    public int getId_jobs() {
        return id_jobs;
    }

    public void setId_jobs(int id_jobs) {
        this.id_jobs = id_jobs;
    }

    public String getNom_job() {
        return nom_job;
    }

    public void setNom_job(String nom_job) {
        this.nom_job = nom_job;
    }

    public String getDescription_job() {
        return description_job;
    }

    public void setDescription_job(String description_job) {
        this.description_job = description_job;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public String getMot_cle() {
        return mot_cle;
    }

    public void setMot_cle(String mot_cle) {
        this.mot_cle = mot_cle;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getSecteur_opportunite() {
        return secteur_opportunite;
    }

    public void setSecteur_opportunite(String secteur_opportunite) {
        this.secteur_opportunite = secteur_opportunite;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public List<Prospect> getProspects() {
        return prospects;
    }

    public void setProspects(List<Prospect> prospects) {
        this.prospects = prospects;
    }

    @Override
    public String toString() {
        return "JobsDTO{" +
                "id_jobs=" + id_jobs +
                ", nom_job='" + nom_job + '\'' +
                ", description_job='" + description_job + '\'' +
                ", dateCreation=" + dateCreation +
                ", deadline=" + deadline +
                ", priorite='" + priorite + '\'' +
                ", status='" + status + '\'' +
                ", userCreation='" + userCreation + '\'' +
                ", mot_cle='" + mot_cle + '\'' +
                ", canal='" + canal + '\'' +
                ", secteur_opportunite='" + secteur_opportunite + '\'' +
                ", commentaires=" + commentaires +
                ", prospects=" + prospects +
                '}';
    }
}
