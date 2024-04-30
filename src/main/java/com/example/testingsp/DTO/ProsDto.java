package com.example.testingsp.DTO;

public class ProsDto {

    private String prospectDomaine;
    private Long count;

    public ProsDto(String prospectDomaine, Long count) {
        this.prospectDomaine = prospectDomaine;
        this.count = count;
    }

    public String getProspectDomaine() {
        return prospectDomaine;
    }

    public void setProspectDomaine(String prospectDomaine) {
        this.prospectDomaine = prospectDomaine;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
