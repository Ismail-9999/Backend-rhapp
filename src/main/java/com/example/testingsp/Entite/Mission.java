package com.example.testingsp.Entite;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mission_id ;
    private String mission_ref ;
    private String designation;
    private String lieuimput;
    private String entite;
    private BigDecimal nombrej;


    @ManyToMany (fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Consultant> missions;

    @ManyToOne (fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Client client ;

    public Mission(int mission_id, String mission_ref, String designation, String lieuimput, String entite,
                   BigDecimal nombrej, List<Consultant> missions, Client client) {
        this.mission_id = mission_id;
        this.mission_ref = mission_ref;
        this.designation = designation;
        this.lieuimput = lieuimput;
        this.entite = entite;
        this.nombrej = nombrej;
        this.missions = missions;
        this.client = client;
    }

    public Mission(String mission_ref, String designation, String lieuimput, String entite, BigDecimal nombrej, List<Consultant> missions, Client client) {
        this.mission_ref = mission_ref;
        this.designation = designation;
        this.lieuimput = lieuimput;
        this.entite = entite;
        this.nombrej = nombrej;
        this.missions = missions;
        this.client = client;
    }

    public Mission() {
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
        return "Mission{" +
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
