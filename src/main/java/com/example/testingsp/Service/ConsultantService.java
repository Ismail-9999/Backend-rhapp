package com.example.testingsp.Service;


import com.example.testingsp.DTO.ConsultantSaveDTO;
import com.example.testingsp.DTO.ConsultantUpDTO;
import com.example.testingsp.Entite.Consultant;

import java.util.List;

public interface ConsultantService {
    String addConsultant(ConsultantSaveDTO consultantSaveDTO);

    List showConsultant();

    Consultant getConsultantbyId(int consultantid);

    String updateConsultant(ConsultantUpDTO consultantUpDTO);

    //nouveau
    String closeConsultant( int consultantId);
    String reopenConsultant(int consultantId);
    //void updateConsStatus();

    String getConsultantName(int consultantid);

    boolean deleteConsultant(int id);
}
