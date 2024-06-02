package com.example.testingsp.DTO;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;


public class FileEntityDTO {

    private Long id;

    private String fileName;

    private String prospectId;


    public FileEntityDTO() {
    }

    public FileEntityDTO(Long id, String fileName, String prospectId) {
        this.id = id;
        this.fileName = fileName;
        this.prospectId = prospectId;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getProspectId() {
        return prospectId;
    }

    public void setProspectId(String prospectId) {
        this.prospectId = prospectId;
    }


    @Override
    public String toString() {
        return "FileEntity{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", prospectId='" + prospectId + '\'' +
                '}';
    }
}
