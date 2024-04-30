package com.example.testingsp.Service;

import com.example.testingsp.DTO.MissionsaveDTO;
import com.example.testingsp.DTO.ServiceChart;

import java.util.List;

public interface MissionService {
    String addMission(MissionsaveDTO missionsaveDTO);

    List showMission();

    String getMissionDes(int mission_id);

    void addConsultantToMission(int mission_id, int consultantid);

    List<Object[]> getServicesdata();

    List<Object[]> getClientdata();

    List<ServiceChart> getDashTable();
}
