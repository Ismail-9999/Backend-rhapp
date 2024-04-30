package com.example.testingsp.Service;

import com.example.testingsp.DTO.ConsultantDTO;
import com.example.testingsp.DTO.ConsultantSaveDTO;
import com.example.testingsp.DTO.ConsultantUpDTO;
import com.example.testingsp.DTO.ProspectUpDTO;
import com.example.testingsp.Entite.Consultant;
import com.example.testingsp.Entite.Mission;
import com.example.testingsp.Entite.Prospect;
import com.example.testingsp.Repository.ConsultantRepo;
import com.example.testingsp.Repository.MissionRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultantIMPL implements ConsultantService {

    @Autowired
    public ConsultantRepo consultantRepo;
    @Autowired
    public MissionRepo missionRepo ;

    @Override
    public String addConsultant(ConsultantSaveDTO consultantSaveDTO){
        Consultant consultant = new Consultant(
                consultantSaveDTO.getConsultantname(),
                consultantSaveDTO.getStatus(),
                consultantSaveDTO.getConsultantcin(),
                consultantSaveDTO.getConsultantbirthdate(),
                consultantSaveDTO.getExperiencepro(),
                consultantSaveDTO.getSecteuractivite(),
                consultantSaveDTO.getEmail(),
                consultantSaveDTO.getCompetencemetier(),
                consultantSaveDTO.getTJM(),
                consultantSaveDTO.getMobile(),
                consultantSaveDTO.getMission()

        );
        consultantRepo.save(consultant);
        return consultant.getStatus();
    }


    @Override
    public List showConsultant(){
        List<Consultant> showprospect = consultantRepo.findAll();
        List<ConsultantDTO> consultantDTOList = new ArrayList<>();

        for (Consultant i : showprospect){
            ConsultantDTO consultantDTO = new ConsultantDTO(
                    i.getConsultantid(),
                    i.getConsultantname(),
                    i.getStatus(),
                    i.getConsultantcin(),
                    i.getConsultantbirthdate(),
                    i.getExperiencepro(),
                    i.getSecteuractivite(),
                    i.getEmail(),
                    i.getCompetencemetier(),
                    i.getTJM(),
                    i.getMobile(),
                    i.getMission()

            );
            consultantDTOList.add(consultantDTO);
        }
        return consultantDTOList ;
    }

    @Override

    public Consultant getConsultantbyId(int consultantid){
        Optional<Consultant> optionalConsultant = consultantRepo.findById(consultantid);

        if (optionalConsultant.isPresent()) {
            return  optionalConsultant.get();
        }
        else {
            throw  new EntityNotFoundException(("  introuvable"+ consultantid));
        }

    }

    @Override
    public  String updateConsultant(ConsultantUpDTO consultantUpDTO){
        if (consultantRepo.existsById(consultantUpDTO.getConsultantid())){
            Consultant consultant = consultantRepo.getById(consultantUpDTO.getConsultantid());


            consultant.setTJM(consultantUpDTO.getTJM());
            consultant.setSecteuractivite(consultantUpDTO.getSecteuractivite());
            consultant.setExperiencepro(consultantUpDTO.getExperiencepro());
            consultant.setConsultantcin(consultantUpDTO.getConsultantcin());
            consultant.setEmail(consultantUpDTO.getEmail());
            consultant.setConsultantbirthdate(consultantUpDTO.getConsultantbirthdate());
            consultant.setConsultantname(consultantUpDTO.getConsultantname());
            consultant.setStatus(consultantUpDTO.getStatus());
            consultant.setMobile(consultantUpDTO.getMobile());
            consultant.setCompetencemetier(consultantUpDTO.getCompetencemetier());


            consultantRepo.save(consultant);
            return "Consultant updated successfully";
        }
        else  {
            System.out.println("Id introuvable");
        }
        return null ;
    }

    @Override
    public String getConsultantName(int consultantid) {
        Optional<Consultant> consultantOptional = consultantRepo.findById(consultantid);

        if (consultantOptional.isPresent()) {
            Consultant consultant = consultantOptional.get();
            return consultant.getConsultantname();
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteConsultant(int id) {

        if(consultantRepo.existsById(id)) {
            consultantRepo.deleteById(id);

        }
        else{
            System.out.println("Consultant id introuvable");
        }
        return true;
    }

   /* @Override
    public boolean deleteConsultant2(int id) {
        if (consultantRepo.existsById(id)) {
            // Check for and delete associated records in mission_missions
            List<Mission> missions = missionRepo.findByConsultantId(id);
            if (!missions.isEmpty()) {
                // Assuming Mission entity has a consultantId field
                for (Mission mission : missions) {
                    mission.setConsultantId(null); // Update foreign key to null or handle as needed
                    missionRepo.save(mission);
                }
            }

            consultantRepo.deleteById(id);
        } else {
            System.out.println("Consultant id introuvable");
        }
        return true;
    }*/

}
