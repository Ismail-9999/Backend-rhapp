package com.example.testingsp.Entite;


import jakarta.persistence.*;

@Entity
@Table(name="testapp")
public class TestingSP {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int testID ;

    private String featuers ;

    private String description  ;

    private long featuersid ;

    public TestingSP(int testID, String featuers, String description, long featuersid) {
        this.testID = testID;
        this.featuers = featuers;
        this.description = description;
        this.featuersid = featuersid;
    }

    public TestingSP() {
    }

    public TestingSP(String featuers, String description, long featuersid) {
        this.featuers = featuers;
        this.description = description;
        this.featuersid = featuersid;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public String getFeatuers() {
        return featuers;
    }

    public void setFeatuers(String featuers) {
        this.featuers = featuers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getFeatuersid() {
        return featuersid;
    }

    public void setFeatuersid(long featuersid) {
        this.featuersid = featuersid;
    }

    @Override
    public String toString() {
        return "TestingSP{" +
                "testID=" + testID +
                ", featuers='" + featuers + '\'' +
                ", description='" + description + '\'' +
                ", featuersid=" + featuersid +
                '}';
    }
}


