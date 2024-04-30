package com.example.testingsp.DTO;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ServiceChart {

    private String consultantname ;

    private long tjm ;

    private String clientname ;

    private long countmis ;

    public ServiceChart(String consultantname, long tjm, String clientname, long countmis) {
        this.consultantname = consultantname;
        this.tjm = tjm;
        this.clientname = clientname;
        this.countmis = countmis;
    }

    public String getConsultantname() {
        return consultantname;
    }

    public void setConsultantname(String consultantname) {
        this.consultantname = consultantname;
    }

    public long getTjm() {
        return tjm;
    }

    public void setTjm(long tjm) {
        this.tjm = tjm;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public long getCountmis() {
        return countmis;
    }

    public void setCountmis(long countmis) {
        this.countmis = countmis;
    }
}
