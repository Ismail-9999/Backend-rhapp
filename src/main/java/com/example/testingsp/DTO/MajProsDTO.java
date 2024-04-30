package com.example.testingsp.DTO;

public class MajProsDTO {

    private String rl_majcv ;

    private Long count ;

    public MajProsDTO(String rl_majcv, Long count) {
        this.rl_majcv = rl_majcv;
        this.count = count;
    }

    public String getMajcv() {
        return rl_majcv;
    }

    public void setMajcv(String majcv) {
        this.rl_majcv = majcv;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
