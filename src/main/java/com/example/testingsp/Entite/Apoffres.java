package com.example.testingsp.Entite;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.security.Timestamp;
import java.util.Date;

@Entity
@Table(name = "appl_offre")
public class Apoffres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_offres ;

    private String missions ;
    @ManyToOne (fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Client clients ;
    private Boolean D_administratif;
    private Boolean D_financier ;
    private Boolean Cv_formater ;
    private Date heure ;
    private String  consultation ;

    private Date  limite_soumission;
    private String Consultant;
    private Date consultation_date ;
    private Date date_solicit;
    private String canal_solicit;
    private boolean soumission ;
    private String soumi_desc;
    private long TJM ;
    private String Disponibilité;
    private String rl_client ;
    private String rl_aft_client ;
    private Date Entretien ;
    private String appl_entretien ;
    private String alrt_entretien ;
    private String rl_aft_entretien;
    private String sort_entretien ;
    private  String notif_condidat ;
    private  String cl_interlocu ;


    public Apoffres() {
    }


    public Apoffres(int id_offres, String missions, Client clients, Boolean d_administratif, Boolean d_financier, Boolean cv_formater, Date consultation_date, Date heure, String consultation, Date limite_soumission, String consultant, Date date_solicit, String canal_solicit, boolean soumission, String soumi_desc, long TJM, String disponibilité, String rl_client, String rl_aft_client, Date entretien, String appl_entretien, String alrt_entretien, String rl_aft_entretien, String sort_entretien, String notif_condidat, String cl_interlocu) {
        this.id_offres = id_offres;
        this.missions = missions;
        this.clients = clients;
        D_administratif = d_administratif;
        D_financier = d_financier;
        Cv_formater = cv_formater;
        this.consultation_date = consultation_date;
        this.heure = heure;
        this.consultation = consultation;
        this.limite_soumission = limite_soumission;
        Consultant = consultant;
        this.date_solicit = date_solicit;
        this.canal_solicit = canal_solicit;
        this.soumission = soumission;
        this.soumi_desc = soumi_desc;
        this.TJM = TJM;
        Disponibilité = disponibilité;
        this.rl_client = rl_client;
        this.rl_aft_client = rl_aft_client;
        Entretien = entretien;
        this.appl_entretien = appl_entretien;
        this.alrt_entretien = alrt_entretien;
        this.rl_aft_entretien = rl_aft_entretien;
        this.sort_entretien = sort_entretien;
        this.notif_condidat = notif_condidat;
        this.cl_interlocu = cl_interlocu;
    }


    public Apoffres(String missions, Client clients, Boolean d_administratif, Boolean d_financier, Boolean cv_formater, Date consultation_date, Date heure, String consultation, Date limite_soumission, String consultant, Date date_solicit, String canal_solicit, boolean soumission, String soumi_desc, long TJM, String disponibilité, String rl_client, String rl_aft_client, Date entretien, String appl_entretien, String alrt_entretien, String rl_aft_entretien, String sort_entretien, String notif_condidat, String cl_interlocu) {
        this.missions = missions;
        this.clients = clients;
        D_administratif = d_administratif;
        D_financier = d_financier;
        Cv_formater = cv_formater;
        this.consultation_date = consultation_date;
        this.heure = heure;
        this.consultation = consultation;
        this.limite_soumission = limite_soumission;
        Consultant = consultant;
        this.date_solicit = date_solicit;
        this.canal_solicit = canal_solicit;
        this.soumission = soumission;
        this.soumi_desc = soumi_desc;
        this.TJM = TJM;
        Disponibilité = disponibilité;
        this.rl_client = rl_client;
        this.rl_aft_client = rl_aft_client;
        Entretien = entretien;
        this.appl_entretien = appl_entretien;
        this.alrt_entretien = alrt_entretien;
        this.rl_aft_entretien = rl_aft_entretien;
        this.sort_entretien = sort_entretien;
        this.notif_condidat = notif_condidat;
        this.cl_interlocu = cl_interlocu;
    }

    public int getId_offres() {
        return id_offres;
    }

    public void setId_offres(int id_offres) {
        this.id_offres = id_offres;
    }

    public String getMissions() {
        return missions;
    }

    public void setMissions(String missions) {
        this.missions = missions;
    }

    public Client getClient() {
        return clients;
    }

    public void setClient(Client clients) {
        this.clients = clients;
    }

    public Boolean getD_administratif() {
        return D_administratif;
    }

    public void setD_administratif(Boolean d_administratif) {
        D_administratif = d_administratif;
    }

    public Boolean getD_financier() {
        return D_financier;
    }

    public void setD_financier(Boolean d_financier) {
        D_financier = d_financier;
    }

    public Boolean getCv_formater() {
        return Cv_formater;
    }

    public void setCv_formater(Boolean cv_formater) {
        Cv_formater = cv_formater;
    }

    public Date getConsultation_date() {
        return consultation_date;
    }

    public void setConsultation_date(Date consultation_date) {
        this.consultation_date = consultation_date;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public String getConsultation() {
        return consultation;
    }

    public void setConsultation(String consultation) {
        this.consultation = consultation;
    }

    public Date getLimite_soumission() {
        return limite_soumission;
    }

    public void setLimite_soumission(Date limite_soumission) {
        this.limite_soumission = limite_soumission;
    }

    public String getConsultant() {
        return Consultant;
    }

    public void setConsultant(String consultant) {
        Consultant = consultant;
    }

    public Date getDate_solicit() {
        return date_solicit;
    }

    public void setDate_solicit(Date date_solicit) {
        this.date_solicit = date_solicit;
    }

    public String getCanal_solicit() {
        return canal_solicit;
    }

    public void setCanal_solicit(String canal_solicit) {
        this.canal_solicit = canal_solicit;
    }

    public boolean isSoumission() {
        return soumission;
    }

    public void setSoumission(boolean soumission) {
        this.soumission = soumission;
    }

    public String getSoumi_desc() {
        return soumi_desc;
    }

    public void setSoumi_desc(String soumi_desc) {
        this.soumi_desc = soumi_desc;
    }

    public long getTJM() {
        return TJM;
    }

    public void setTJM(long TJM) {
        this.TJM = TJM;
    }

    public String getDisponibilité() {
        return Disponibilité;
    }

    public void setDisponibilité(String disponibilité) {
        Disponibilité = disponibilité;
    }

    public String getRl_client() {
        return rl_client;
    }

    public void setRl_client(String rl_client) {
        this.rl_client = rl_client;
    }

    public String getRl_aft_client() {
        return rl_aft_client;
    }

    public void setRl_aft_client(String rl_aft_client) {
        this.rl_aft_client = rl_aft_client;
    }

    public Date getEntretien() {
        return Entretien;
    }

    public void setEntretien(Date entretien) {
        Entretien = entretien;
    }

    public String getAppl_entretien() {
        return appl_entretien;
    }

    public void setAppl_entretien(String appl_entretien) {
        this.appl_entretien = appl_entretien;
    }

    public String getAlrt_entretien() {
        return alrt_entretien;
    }

    public void setAlrt_entretien(String alrt_entretien) {
        this.alrt_entretien = alrt_entretien;
    }

    public String getRl_aft_entretien() {
        return rl_aft_entretien;
    }

    public void setRl_aft_entretien(String rl_aft_entretien) {
        this.rl_aft_entretien = rl_aft_entretien;
    }

    public String getSort_entretien() {
        return sort_entretien;
    }

    public void setSort_entretien(String sort_entretien) {
        this.sort_entretien = sort_entretien;
    }

    public String getNotif_condidat() {
        return notif_condidat;
    }

    public void setNotif_condidat(String notif_condidat) {
        this.notif_condidat = notif_condidat;
    }

    public String getCl_interlocu() {
        return cl_interlocu;
    }

    public void setCl_interlocu(String cl_interlocu) {
        this.cl_interlocu = cl_interlocu;
    }


    @Override
    public String toString() {
        return "Apoffres{" +
                "id_offres=" + id_offres +
                ", missions='" + missions + '\'' +
                ", clients=" + clients +
                ", D_administratif=" + D_administratif +
                ", D_financier=" + D_financier +
                ", Cv_formater=" + Cv_formater +
                ", consultation_date=" + consultation_date +
                ", heure=" + heure +
                ", consultation='" + consultation + '\'' +
                ", limite_soumission=" + limite_soumission +
                ", Consultant='" + Consultant + '\'' +
                ", date_solicit=" + date_solicit +
                ", canal_solicit='" + canal_solicit + '\'' +
                ", soumission=" + soumission +
                ", soumi_desc='" + soumi_desc + '\'' +
                ", TJM=" + TJM +
                ", Disponibilité='" + Disponibilité + '\'' +
                ", rl_client='" + rl_client + '\'' +
                ", rl_aft_client='" + rl_aft_client + '\'' +
                ", Entretien=" + Entretien +
                ", appl_entretien='" + appl_entretien + '\'' +
                ", alrt_entretien='" + alrt_entretien + '\'' +
                ", rl_aft_entretien='" + rl_aft_entretien + '\'' +
                ", sort_entretien='" + sort_entretien + '\'' +
                ", notif_condidat='" + notif_condidat + '\'' +
                ", cl_interlocu='" + cl_interlocu + '\'' +
                '}';
    }
}
