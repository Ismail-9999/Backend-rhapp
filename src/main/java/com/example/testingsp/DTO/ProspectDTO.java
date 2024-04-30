package com.example.testingsp.DTO;

import jakarta.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class ProspectDTO {
    private int IDTIERS ;


    private String EMAIL ;

    private String  NOM ;
    private String status ;
    private String PAYSRESIDENCE ;
    private String  SECTEURACTIVITE ;
    private long TELEPHONE ;
    private String CIN ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    private String PROFESSION ;
    private String SEXE ;
    private long ANNEEEXPERIENCE ;
    private String COMPETENCEMETIER ;
    private String COMPETENCETECHNIQUE ;
    private String DISPONIBILITE ;
    private String EXPERIENCEPROFESSIONNELLE ;
    private String FORMATION;
    private String LANGUE;
 
    private String MAJCV;

    private String MOTCLE ;
    private String NIVEAUACADEMIQUE ;

    private Date rl_majcv ;
    private String rl_desc ;

    public ProspectDTO(int IDTIERS, String EMAIL, String NOM, String status, String PAYSRESIDENCE, String SECTEURACTIVITE, long TELEPHONE, String CIN, Date dateNaissance, String PROFESSION, String SEXE, long ANNEEEXPERIENCE, String COMPETENCEMETIER, String COMPETENCETECHNIQUE, String DISPONIBILITE, String EXPERIENCEPROFESSIONNELLE, String FORMATION, String LANGUE, String MAJCV, String MOTCLE, String NIVEAUACADEMIQUE, Date rl_majcv, String rl_desc) {
        this.IDTIERS = IDTIERS;
        this.EMAIL = EMAIL;
        this.NOM = NOM;
        this.status = status;
        this.PAYSRESIDENCE = PAYSRESIDENCE;
        this.SECTEURACTIVITE = SECTEURACTIVITE;
        this.TELEPHONE = TELEPHONE;
        this.CIN = CIN;
        this.dateNaissance = dateNaissance;
        this.PROFESSION = PROFESSION;
        this.SEXE = SEXE;
        this.ANNEEEXPERIENCE = ANNEEEXPERIENCE;
        this.COMPETENCEMETIER = COMPETENCEMETIER;
        this.COMPETENCETECHNIQUE = COMPETENCETECHNIQUE;
        this.DISPONIBILITE = DISPONIBILITE;
        this.EXPERIENCEPROFESSIONNELLE = EXPERIENCEPROFESSIONNELLE;
        this.FORMATION = FORMATION;
        this.LANGUE = LANGUE;
        this.MAJCV = MAJCV;
        this.MOTCLE = MOTCLE;
        this.NIVEAUACADEMIQUE = NIVEAUACADEMIQUE;
        this.rl_majcv = rl_majcv;
        this.rl_desc = rl_desc;
    }

    public int getIDTIERS() {
        return IDTIERS;
    }

    public void setIDTIERS(int IDTIERS) {
        this.IDTIERS = IDTIERS;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPAYSRESIDENCE() {
        return PAYSRESIDENCE;
    }

    public void setPAYSRESIDENCE(String PAYSRESIDENCE) {
        this.PAYSRESIDENCE = PAYSRESIDENCE;
    }

    public String getSECTEURACTIVITE() {
        return SECTEURACTIVITE;
    }

    public void setSECTEURACTIVITE(String SECTEURACTIVITE) {
        this.SECTEURACTIVITE = SECTEURACTIVITE;
    }

    public long getTELEPHONE() {
        return TELEPHONE;
    }

    public void setTELEPHONE(long TELEPHONE) {
        this.TELEPHONE = TELEPHONE;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public  Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance( Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPROFESSION() {
        return PROFESSION;
    }

    public void setPROFESSION(String PROFESSION) {
        this.PROFESSION = PROFESSION;
    }

    public String getSEXE() {
        return SEXE;
    }

    public void setSEXE(String SEXE) {
        this.SEXE = SEXE;
    }

    public long getANNEEEXPERIENCE() {
        return ANNEEEXPERIENCE;
    }

    public void setANNEEEXPERIENCE(long ANNEEEXPERIENCE) {
        this.ANNEEEXPERIENCE = ANNEEEXPERIENCE;
    }

    public String getCOMPETENCEMETIER() {
        return COMPETENCEMETIER;
    }

    public void setCOMPETENCEMETIER(String COMPETENCEMETIER) {
        this.COMPETENCEMETIER = COMPETENCEMETIER;
    }

    public String getCOMPETENCETECHNIQUE() {
        return COMPETENCETECHNIQUE;
    }

    public void setCOMPETENCETECHNIQUE(String COMPETENCETECHNIQUE) {
        this.COMPETENCETECHNIQUE = COMPETENCETECHNIQUE;
    }

    public String getDISPONIBILITE() {
        return DISPONIBILITE;
    }

    public void setDISPONIBILITE(String DISPONIBILITE) {
        this.DISPONIBILITE = DISPONIBILITE;
    }

    public String getEXPERIENCEPROFESSIONNELLE() {
        return EXPERIENCEPROFESSIONNELLE;
    }

    public void setEXPERIENCEPROFESSIONNELLE(String EXPERIENCEPROFESSIONNELLE) {
        this.EXPERIENCEPROFESSIONNELLE = EXPERIENCEPROFESSIONNELLE;
    }

    public String getFORMATION() {
        return FORMATION;
    }

    public void setFORMATION(String FORMATION) {
        this.FORMATION = FORMATION;
    }

    public String getLANGUE() {
        return LANGUE;
    }

    public void setLANGUE(String LANGUE) {
        this.LANGUE = LANGUE;
    }

    public String getMAJCV() {
        return MAJCV;
    }

    public void setMAJCV(String MAJCV) {
        this.MAJCV = MAJCV;
    }

    public String getMOTCLE() {
        return MOTCLE;
    }

    public void setMOTCLE(String MOTCLE) {
        this.MOTCLE = MOTCLE;
    }

    public String getNIVEAUACADEMIQUE() {
        return NIVEAUACADEMIQUE;
    }

    public void setNIVEAUACADEMIQUE(String NIVEAUACADEMIQUE) {
        this.NIVEAUACADEMIQUE = NIVEAUACADEMIQUE;
    }

    public Date getRl_majcv() {
        return rl_majcv;
    }

    public void setRl_majcv(Date rl_majcv) {
        this.rl_majcv = rl_majcv;
    }

    public String getRl_desc() {
        return rl_desc;
    }

    public void setRl_desc(String rl_desc) {
        this.rl_desc = rl_desc;
    }


    @Override
    public String toString() {
        return "ProspectDTO{" +
                "IDTIERS=" + IDTIERS +
                ", EMAIL='" + EMAIL + '\'' +
                ", NOM='" + NOM + '\'' +
                ", status='" + status + '\'' +
                ", PAYSRESIDENCE='" + PAYSRESIDENCE + '\'' +
                ", SECTEURACTIVITE='" + SECTEURACTIVITE + '\'' +
                ", TELEPHONE=" + TELEPHONE +
                ", CIN='" + CIN + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", PROFESSION='" + PROFESSION + '\'' +
                ", SEXE='" + SEXE + '\'' +
                ", ANNEEEXPERIENCE=" + ANNEEEXPERIENCE +
                ", COMPETENCEMETIER='" + COMPETENCEMETIER + '\'' +
                ", COMPETENCETECHNIQUE='" + COMPETENCETECHNIQUE + '\'' +
                ", DISPONIBILITE='" + DISPONIBILITE + '\'' +
                ", EXPERIENCEPROFESSIONNELLE='" + EXPERIENCEPROFESSIONNELLE + '\'' +
                ", FORMATION='" + FORMATION + '\'' +
                ", LANGUE='" + LANGUE + '\'' +
                ", MAJCV='" + MAJCV + '\'' +
                ", MOTCLE='" + MOTCLE + '\'' +
                ", NIVEAUACADEMIQUE='" + NIVEAUACADEMIQUE + '\'' +
                ", rl_majcv=" + rl_majcv +
                ", rl_desc='" + rl_desc + '\'' +
                '}';
    }
}
