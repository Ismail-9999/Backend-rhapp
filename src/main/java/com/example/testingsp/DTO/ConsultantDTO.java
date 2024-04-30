package com.example.testingsp.DTO;

import com.example.testingsp.Entite.Mission;

import java.util.Date;
import java.util.List;

public class ConsultantDTO {

    private int consultantid;

    private String consultantname;

    private String status;

    private String consultantcin;

    private Date consultantbirthdate;
    private String experiencepro ;
    private String secteuractivite ;
    private String email ;
    private String competencemetier ;
    private long TJM ;


    private long mobile;

    private List<Mission> mission ;


    public ConsultantDTO(int consultantid, String consultantname, String status, String consultantcin, Date consultantbirthdate, String experiencepro, String secteuractivite, String email, String competencemetier, long TJM, long mobile, List<Mission> mission) {
        this.consultantid = consultantid;
        this.consultantname = consultantname;
        this.status = status;
        this.consultantcin = consultantcin;
        this.consultantbirthdate = consultantbirthdate;
        this.experiencepro = experiencepro;
        this.secteuractivite = secteuractivite;
        this.email = email;
        this.competencemetier = competencemetier;
        this.TJM = TJM;
        this.mobile = mobile;
        this.mission = mission;
    }

    public int getConsultantid() {
        return consultantid;
    }

    public void setConsultantid(int consultantid) {
        this.consultantid = consultantid;
    }

    public String getConsultantname() {
        return consultantname;
    }

    public void setConsultantname(String consultantname) {
        this.consultantname = consultantname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConsultantcin() {
        return consultantcin;
    }

    public void setConsultantcin(String consultantcin) {
        this.consultantcin = consultantcin;
    }

    public Date getConsultantbirthdate() {
        return consultantbirthdate;
    }

    public void setConsultantbirthdate(Date consultantbirthdate) {
        this.consultantbirthdate = consultantbirthdate;
    }

    public String getExperiencepro() {
        return experiencepro;
    }

    public void setExperiencepro(String experiencepro) {
        this.experiencepro = experiencepro;
    }

    public String getSecteuractivite() {
        return secteuractivite;
    }

    public void setSecteuractivite(String secteuractivite) {
        this.secteuractivite = secteuractivite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompetencemetier() {
        return competencemetier;
    }

    public void setCompetencemetier(String competencemetier) {
        this.competencemetier = competencemetier;
    }

    public long getTJM() {
        return TJM;
    }

    public void setTJM(long TJM) {
        this.TJM = TJM;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public List<Mission> getMission() {
        return mission;
    }

    public void setMission(List<Mission> mission) {
        this.mission = mission;
    }

    @Override
    public String toString() {
        return "ConsultantDTO{" +
                "consultantid=" + consultantid +
                ", consultantname='" + consultantname + '\'' +
                ", status='" + status + '\'' +
                ", consultantcin='" + consultantcin + '\'' +
                ", consultantbirthdate=" + consultantbirthdate +
                ", experiencepro='" + experiencepro + '\'' +
                ", secteuractivite='" + secteuractivite + '\'' +
                ", email='" + email + '\'' +
                ", competencemetier='" + competencemetier + '\'' +
                ", TJM=" + TJM +
                ", mobile=" + mobile +
                ", mission=" + mission +
                '}';
    }
}
