package com.example.testingsp.Controller;


import com.example.testingsp.DTO.*;
import com.example.testingsp.Entite.Consultant;
import com.example.testingsp.Entite.Prospect;
import com.example.testingsp.Service.ProspectService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://i-team.ma"})
@RequestMapping("api/prospect")
public class ProspectCont {

@Autowired
private ProspectService prospectService ;


    @PostMapping(path = "add")
    @CacheEvict(value = "prospecting", allEntries = true)
    public String savepros (@RequestBody ProspectSaveDTO prospectSaveDTO){
        String id = prospectService.addProspect(prospectSaveDTO);
        return id ;
    }

    @PutMapping("/update")
    @CacheEvict(value = "prospecting", allEntries = true)
    public ResponseEntity<String> updateProspect(@RequestBody ProspectUpDTO prospectUpDTO) {
        String result = prospectService.updateProspect(prospectUpDTO);
        if (result.startsWith("Prospect updated")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping(path = "prospect")
    @Cacheable("prospecting")
    public List<ProspectDTO> showProspect(){
    List<ProspectDTO> allProspect = prospectService.showProspect();
    return allProspect ;
        }

        @GetMapping(path = "/norelance")
        @CacheEvict(value = "prospecting", allEntries = true)
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
       @CacheEvict(value = "prospecting", allEntries = true)
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
                prospect.getPROJETPROFESSIONNEL(),
                prospect.getFORMATION(),
                prospect.getCERTIFICATION(),
                prospect.getLANGUE(),
                prospect.getMAJCV(),
                prospect.getMOTCLE(),
                prospect.getNIVEAUACADEMIQUE(),
                prospect.getRl_majcv(),
                prospect.getRl_desc(),
                prospect.getDateCreation(),
                prospect.getUserCreation()
              //  prospect.getJobs()

        );

           return prospectDTO ;
        }


    @DeleteMapping (path="/delete/{id}")
    @CacheEvict(value = "prospecting", allEntries = true)
    public String deleteProspect(@PathVariable(value = "id")int id)
    {
        boolean deleteProspect = prospectService.deleteProspect(id);
        return "Supprimer";
    }

    @PostMapping("/convert/{idtiers}")
    @CacheEvict(value = "prospecting", allEntries = true)
    public ResponseEntity<Consultant> convertToConsultant(@PathVariable int idtiers){
        Consultant consultant = prospectService.convertToConsultant(idtiers);
        return ResponseEntity.ok(consultant);
    }



    @GetMapping("/chart")
    @CacheEvict(value = "prospecting", allEntries = true)
    public List<ProsDto> getChart() {
        return prospectService.getChartData();
    }


    @GetMapping("/maj")
    @CacheEvict(value = "prospecting", allEntries = true)
    public List<MajProsDTO> getMajData() {
        return prospectService.getMajData();
    }

    @PostMapping("/updateStatus")
    @CacheEvict(value = "prospecting", allEntries = true)
    public ResponseEntity<String> updateProspectStatusManually() {
        prospectService.updateProspectStatus();
        return ResponseEntity.ok("Prospect status update initiated.");
    }
    @GetMapping("/nameID/{id}")
    @CacheEvict(value = "prospecting", allEntries = true)
    public ResponseEntity<String> getNameProspect(@PathVariable Integer id) {
           String ProspectName = prospectService.getProspectNameById(id);
           if(ProspectName != null) {
               return ResponseEntity.ok(ProspectName);
           } else {
               return ResponseEntity.notFound().build();
           }
    }
    @GetMapping("/search")
    @CacheEvict(value = "prospecting",allEntries = true)
    public List<Prospect> searchProspects(@RequestParam String keyword) {
           return prospectService.searchProspectsByKeyword(keyword);
    }

    /*@GetMapping("/search")
    @CacheEvict(value = "prospecting",allEntries = true)
    public List<Prospect> searchProspects(@RequestParam String keyword) {
        List<Prospect> prospects = prospectService.searchProspectsByKeyword(keyword);
        System.out.println("Number of prospects returned: " + prospects.size()); // Log the number of results
        return prospects;
    }
     */

}
