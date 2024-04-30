package com.example.testingsp.Entite;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clientid ;

    private String clientname ;

    private String client_add ;

    private String client_ice ;


    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Mission> mission ;

    @OneToMany(mappedBy = "clients", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Apoffres> apofres ;

    public Client(int clientid, String clientname, String client_add, String client_ice, List<Mission> mission, List<Apoffres> apofres) {
        this.clientid = clientid;
        this.clientname = clientname;
        this.client_add = client_add;
        this.client_ice = client_ice;
        this.mission = mission;
        this.apofres = apofres;
    }


    public Client(String clientname, String client_add, String client_ice, List<Mission> mission, List<Apoffres> apofres) {
        this.clientname = clientname;
        this.client_add = client_add;
        this.client_ice = client_ice;
        this.mission = mission;
        this.apofres = apofres;
    }

    public Client() {
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getClient_add() {
        return client_add;
    }

    public void setClient_add(String client_add) {
        this.client_add = client_add;
    }

    public String getClient_ice() {
        return client_ice;
    }

    public void setClient_ice(String client_ice) {
        this.client_ice = client_ice;
    }

    public List<Mission> getMission() {
        return mission;
    }

    public void setMission(List<Mission> mission) {
        this.mission = mission;
    }

    public List<Apoffres> getApofres() {
        return apofres;
    }

    public void setApofres(List<Apoffres> apofres) {
        this.apofres = apofres;
    }


    @Override
    public String toString() {
        return "Client{" +
                "clientid=" + clientid +
                ", clientname='" + clientname + '\'' +
                ", client_add='" + client_add + '\'' +
                ", client_ice='" + client_ice + '\'' +
                ", mission=" + mission +
                ", apofres=" + apofres +
                '}';
    }
}