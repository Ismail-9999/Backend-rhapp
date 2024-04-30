package com.example.testingsp.DTO;

import com.example.testingsp.Entite.Apoffres;
import com.example.testingsp.Entite.Mission;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class ClientDTO {

    private int clientid ;

    private String clientname ;

    private String client_add ;

    private String client_ice ;

    private List<Mission> mission ;

    private List<Apoffres> apofres ;


    public ClientDTO(int clientid, String clientname, String client_add, String client_ice, List<Mission> mission, List<Apoffres> apofres) {
        this.clientid = clientid;
        this.clientname = clientname;
        this.client_add = client_add;
        this.client_ice = client_ice;
        this.mission = mission;
        this.apofres = apofres;
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
        return "ClientDTO{" +
                "clientid=" + clientid +
                ", clientname='" + clientname + '\'' +
                ", client_add='" + client_add + '\'' +
                ", client_ice='" + client_ice + '\'' +
                ", mission=" + mission +
                ", apofres=" + apofres +
                '}';
    }
}
