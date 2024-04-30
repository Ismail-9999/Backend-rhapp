package com.example.testingsp.Service;


import com.example.testingsp.DTO.ApoffresDTO;
import com.example.testingsp.DTO.AppoffresSaveDTO;
import com.example.testingsp.Entite.Apoffres;
import com.example.testingsp.Repository.ApoffresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApoffresIMPL implements  ApoffresService{

    @Autowired
    public ApoffresRepo apoffresRepo ;


    @Override
    public String addOffres(AppoffresSaveDTO appoffresSaveDTO){
        Apoffres apoffres = new Apoffres(
                appoffresSaveDTO.getMissions(),
                appoffresSaveDTO.getClient(),
                appoffresSaveDTO.getD_administratif(),
                appoffresSaveDTO.getD_financier(),
                appoffresSaveDTO.getCv_formater(),
                appoffresSaveDTO.getConsultation_date(),
                appoffresSaveDTO.getHeure(),
                appoffresSaveDTO.getConsultation(),
                appoffresSaveDTO.getLimite_soumission(),
                appoffresSaveDTO.getConsultant(),
                appoffresSaveDTO.getDate_solicit(),
                appoffresSaveDTO.getCanal_solicit(),
                appoffresSaveDTO.isSoumission(),
                appoffresSaveDTO.getSoumi_desc(),
                appoffresSaveDTO.getTJM(),
                appoffresSaveDTO.getDisponibilité(),
                appoffresSaveDTO.getRl_client(),
                appoffresSaveDTO.getRl_aft_client(),
                appoffresSaveDTO.getEntretien(),
                appoffresSaveDTO.getAppl_entretien(),
                appoffresSaveDTO.getAlrt_entretien(),
                appoffresSaveDTO.getRl_aft_entretien(),
                appoffresSaveDTO.getSort_entretien(),
                appoffresSaveDTO.getNotif_condidat(),
                appoffresSaveDTO.getCl_interlocu()
        );
        apoffresRepo.save(apoffres) ;
        return  apoffres.getMissions();
    }

    @Override
    public List showOffres(){
        List<Apoffres> showoffres = apoffresRepo.findAll();
        List<ApoffresDTO> apoffresDTOList =new ArrayList<>();

        for (Apoffres i: showoffres){
            ApoffresDTO apoffresDTO = new ApoffresDTO(
                    i.getId_offres(),
                    i.getMissions(),
                    i.getClient(),
                    i.getD_administratif(),
                    i.getD_financier(),
                    i.getCv_formater(),
                    i.getConsultation_date(),
                    i.getHeure(),
                    i.getConsultation(),
                    i.getLimite_soumission(),
                    i.getConsultant(),
                    i.getDate_solicit(),
                    i.getCanal_solicit(),
                    i.isSoumission(),
                    i.getSoumi_desc(),
                    i.getTJM(),
                    i.getDisponibilité(),
                    i.getRl_client(),
                    i.getRl_aft_client(),
                    i.getEntretien(),
                    i.getAppl_entretien(),
                    i.getAlrt_entretien(),
                    i.getRl_aft_entretien(),
                    i.getSort_entretien(),
                    i.getNotif_condidat(),
                    i.getCl_interlocu()
            );
            apoffresDTOList.add(apoffresDTO);
        }
        return apoffresDTOList ;
    }
}
