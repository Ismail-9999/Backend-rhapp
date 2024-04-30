package com.example.testingsp.DTO;

import com.example.testingsp.Entite.Client;
import com.example.testingsp.Entite.Consultant;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

import java.math.BigDecimal;
import java.util.List;

public class MissionDTO {

    private int mission_id ;
    private String mission_ref ;
    private String designation;
    private String lieuimput;
    private String entite;
    private BigDecimal nombrej;

    private List<Consultant> missions;

    private Client client ;

    public MissionDTO(int mission_id, String mission_ref, String designation, String lieuimput, String entite, BigDecimal nombrej, List<Consultant> missions, Client client) {
        this.mission_id = mission_id;
        this.mission_ref = mission_ref;
        this.designation = designation;
        this.lieuimput = lieuimput;
        this.entite = entite;
        this.nombrej = nombrej;
        this.missions = missions;
        this.client = client;
    }

    public int getMission_id() {
        return mission_id;
    }

    public void setMission_id(int mission_id) {
        this.mission_id = mission_id;
    }

    public String getMission_ref() {
        return mission_ref;
    }

    public void setMission_ref(String mission_ref) {
        this.mission_ref = mission_ref;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLieuimput() {
        return lieuimput;
    }

    public void setLieuimput(String lieuimput) {
        this.lieuimput = lieuimput;
    }

    public String getEntite() {
        return entite;
    }

    public void setEntite(String entite) {
        this.entite = entite;
    }

    public BigDecimal getNombrej() {
        return nombrej;
    }

    public void setNombrej(BigDecimal nombrej) {
        this.nombrej = nombrej;
    }

    public List<Consultant> getMissions() {
        return missions;
    }

    public void setMissions(List<Consultant> missions) {
        this.missions = missions;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "MissionDTO{" +
                "mission_id=" + mission_id +
                ", mission_ref='" + mission_ref + '\'' +
                ", designation='" + designation + '\'' +
                ", lieuimput='" + lieuimput + '\'' +
                ", entite='" + entite + '\'' +
                ", nombrej=" + nombrej +
                ", missions=" + missions +
                ", client=" + client +
                '}';
    }
}
