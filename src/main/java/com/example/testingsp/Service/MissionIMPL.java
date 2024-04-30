package com.example.testingsp.Service;

import com.example.testingsp.DTO.MissionDTO;
import com.example.testingsp.DTO.MissionsaveDTO;
import com.example.testingsp.DTO.ServiceChart;
import com.example.testingsp.Entite.Consultant;
import com.example.testingsp.Entite.Mission;
import com.example.testingsp.Repository.ConsultantRepo;
import com.example.testingsp.Repository.MissionRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MissionIMPL implements MissionService{

    @Autowired
    public MissionRepo missionRepo ;
    @Autowired
    public ConsultantRepo consultantRepo ;


    @Override
    public  String addMission(MissionsaveDTO missionsaveDTO){
        Mission mission = new Mission(

                missionsaveDTO.getMission_ref(),
                missionsaveDTO.getDesignation(),
                missionsaveDTO.getLieuimput(),
                missionsaveDTO.getEntite(),
                missionsaveDTO.getNombrej(),
                missionsaveDTO.getMissions(),
                missionsaveDTO.getClient()
        );
        missionRepo.save(mission);
        return  mission.getMission_ref() ;
    }

    @Override
    public  List showMission(){
        List<Mission> showMission = missionRepo.findAll();
        List<MissionDTO> missionDTOList = new ArrayList<>();

        for (Mission i : showMission){
            MissionDTO missionDTO = new MissionDTO(
              i.getMission_id(),
              i.getMission_ref(),
              i.getDesignation(),
              i.getLieuimput(),
              i.getEntite(),
              i.getNombrej(),
              i.getMissions(),
                    i.getClient()
            );
            missionDTOList.add(missionDTO);
        }
    return missionDTOList ;
    }

    @Override
    public String getMissionDes(int mission_id) {
        Optional<Mission> missionOptional = missionRepo.findById(mission_id);

        if (missionOptional.isPresent()) {
            Mission mission = missionOptional.get();
            return mission.getMission_ref();
        } else {
            return null;
        }
    }


    @Override

    public void addConsultantToMission(int mission_id, int consultantid) {
        Mission mission = missionRepo.findById(mission_id)
                .orElseThrow(() -> new EntityNotFoundException("Mission not found"));

        Consultant consultant = consultantRepo.findById(consultantid)
                .orElseThrow(() -> new EntityNotFoundException("Consultant not found"));

        mission.getMissions().add(consultant);
        consultant.getMission().add(mission);

        missionRepo.save(mission);
        consultantRepo.save(consultant);
    }

    @Override
    public List<Object[]> getServicesdata() {return missionRepo.getServicesdata();}

    @Override
    public List<Object[]> getClientdata() {return missionRepo.getClientdata();}

 /*   @Override
    public List<ServiceChart> getiDashTable() {return missionRepo.getDashTable();}*/

    public List<ServiceChart> getDashTable() {
        List<Object[]> result = missionRepo.getDashTable();
        List<ServiceChart> serviceCharts = new ArrayList<>();

        for (Object row : result) {
            Object[] rowData = (Object[]) row;
            ServiceChart serviceChart = new ServiceChart(
                    (String) rowData[0],
                    ((long) rowData[1]) ,
                    (String) rowData[2],
                    ((long) rowData[3])
            );
            serviceCharts.add(serviceChart);
        }

        return serviceCharts;
    }
}
