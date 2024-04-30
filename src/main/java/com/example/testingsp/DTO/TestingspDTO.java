package com.example.testingsp.DTO;

import lombok.Getter;

public class TestingspDTO {

    private int testID ;

    @Getter
    private String featuers ;

    @Getter
    private String description ;

    @Getter
    private long featuersid ;

    public TestingspDTO(int testID, String featuers, String description, long featuersid) {
        this.testID = testID;
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
        return "Testingsp{" +
                "testID=" + testID +
                ", featuers='" + featuers + '\'' +
                ", description='" + description + '\'' +
                ", featuersid=" + featuersid +
                '}';
    }
}
