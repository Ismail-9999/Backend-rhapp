package com.example.testingsp.Controller;


import com.example.testingsp.DTO.*;
import com.example.testingsp.Entite.Consultant;
import com.example.testingsp.Entite.Prospect;
import com.example.testingsp.Service.ProspectService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/prospect")
public class ProspectCont {

@Autowired
private ProspectService prospectService ;


    @PostMapping(path = "add")
    public String savepros (@RequestBody ProspectSaveDTO prospectSaveDTO){
        String id = prospectService.addProspect(prospectSaveDTO);
        return id ;
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProspect(@RequestBody ProspectUpDTO prospectUpDTO) {
        String result = prospectService.updateProspect(prospectUpDTO);
        if (result.startsWith("Prospect updated")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping(path = "prospect")
    public List<ProspectDTO> showProspect(){
    List<ProspectDTO> allProspect = prospectService.showProspect();
    return allProspect ;
        }

        @GetMapping(path = "/norelance")
        public List<Prospect> getProspectsWithDisponibiliteNotRelance() {
            return prospectService.getProspectsWithDisponibiliteNotRelance();
        }

       /* @GetMapping("/{idtiers}")
    public ResponseEntity<ProspectDTO> getProspectbyId(@PathVariable int idtiers){
            Prospect prospect =prospectService.getProspectbyId(idtiers);
            if (prospect !=null){
                ProspectDTO prospectDTO = convertToDTO(prospect);
                return new ResponseEntity<>(prospectDTO, HttpStatus.OK) ;
            }else {
                return new ResponseEntity<>((HttpStatus.NOT_FOUND));
            }
        }*/
       @GetMapping("/{idtiers}")
       public ResponseEntity<ProspectDTO> getProspectbyId(@PathVariable int idtiers) {
           try {
               Prospect prospect = prospectService.getProspectbyId(idtiers);
               ProspectDTO prospectDTO = convertToDTO(prospect);
               return ResponseEntity.ok(prospectDTO);
           } catch (EntityNotFoundException ex) {
               return ResponseEntity.notFound().build();
           } catch (Exception ex) {
               // Log the exception for further analysis
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
           }
       }

        private ProspectDTO convertToDTO(Prospect prospect){
        ProspectDTO prospectDTO = new ProspectDTO(
                prospect.getIDTIERS(),
                prospect.getEMAIL(),
                prospect.getNOM(),
                prospect.getStatus()
,                prospect.getPAYSRESIDENCE(),
                prospect.getSECTEURACTIVITE(),
                prospect.getTELEPHONE(),
                prospect.getCIN(),
                prospect.getDateNaissance(),
                prospect.getPROFESSION(),
                prospect.getSEXE(),
                prospect.getANNEEEXPERIENCE(),
                prospect.getCOMPETENCEMETIER(),
                prospect.getCOMPETENCETECHNIQUE(),
                prospect.getDISPONIBILITE(),
                prospect.getEXPERIENCEPROFESSIONNELLE(),
                prospect.getFORMATION(),
                prospect.getLANGUE(),
                prospect.getMAJCV(),
                prospect.getMOTCLE(),
                prospect.getNIVEAUACADEMIQUE(),
                prospect.getRl_majcv(),
                prospect.getRl_desc()

        );

           return prospectDTO ;
        }


    @DeleteMapping (path="/delete/{id}")
    public String deleteProspect(@PathVariable(value = "id")int id)
    {
        boolean deleteProspect = prospectService.deleteProspect(id);
        return "Supprimer";
    }

    @PostMapping("/convert/{idtiers}")
    public ResponseEntity<Consultant> convertToConsultant(@PathVariable int idtiers){
        Consultant consultant = prospectService.convertToConsultant(idtiers);
        return ResponseEntity.ok(consultant);
    }



    @GetMapping("/chart")
    public List<ProsDto> getChart() {
        return prospectService.getChartData();
    }


    @GetMapping("/maj")
    public List<MajProsDTO> getMajData() {
        return prospectService.getMajData();
    }

    @PostMapping("/updateStatus")
    public ResponseEntity<String> updateProspectStatusManually() {
        prospectService.updateProspectStatus();
        return ResponseEntity.ok("Prospect status update initiated.");
    }
}
