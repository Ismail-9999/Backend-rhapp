package com.example.testingsp.Controller;


import com.example.testingsp.DTO.*;
import com.example.testingsp.Entite.Consultant;
import com.example.testingsp.Entite.Prospect;
import com.example.testingsp.Repository.ConsultantRepo;
import com.example.testingsp.Service.ConsultantService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/consultant")
public class ConsultantCont {

    @Autowired
    public ConsultantService consultantService;
    @Autowired
    public ConsultantRepo consultantRepo;

    @GetMapping(path = "consultantOP")
    public Page<Consultant> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        PageRequest pageRequest = PageRequest.of(page, size);


        Page<Consultant> consultantPage = consultantRepo.findAll(pageRequest);

        return consultantPage;
    }

    @GetMapping(path = "consultant")
    @Cacheable("consulting")
    public List<ConsultantDTO> showCons() {
        List<ConsultantDTO> allConsultant = consultantService.showConsultant();
        return allConsultant;
    }

    @PostMapping("add")
    @CacheEvict(value = "consulting", allEntries = true)
    public String saveconsultant(@RequestBody ConsultantSaveDTO consultantSaveDTO) {
        String id = consultantService.addConsultant(consultantSaveDTO);
        return id;
    }

    @PutMapping("/update")
    @CacheEvict(value = "consulting", allEntries = true)
    public ResponseEntity<String> updateConsultant(@RequestBody ConsultantUpDTO consultantUpDTO) {
        String result = consultantService.updateConsultant(consultantUpDTO);
        if (result.startsWith("Consultant updated")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //new
    @PutMapping("/close/{consultantId}")
    @CacheEvict(value = "consulting", allEntries = true)
    public ResponseEntity<String> closeConsultant(@PathVariable int consultantId) {
        try {
            String result = consultantService.closeConsultant(consultantId);
            if (result.startsWith("Consultant closed")) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch(EntityNotFoundException ex){
                return ResponseEntity.notFound().build();
            } catch(Exception ex){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
    }

    @PutMapping("/reopen/{consultantId}")
    @CacheEvict(value = "consulting", allEntries = true)
    public ResponseEntity<String> reopenConsultant(@PathVariable int consultantId) {
        try {
            String result = consultantService.reopenConsultant(consultantId);
            if(result.startsWith("Consultant reopened")) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    /*@PutMapping("/updateConsStatus")
    public ResponseEntity<String> updateConsultantStatusManually() {
        consultantService.updateConsultantStatus();
        return ResponseEntity.ok("Consultant status update initiated.");
    }
     */



    @DeleteMapping (path="/delete/{id}")
    @CacheEvict(value = "consulting", allEntries = true)
    public String deleteConsultant(@PathVariable(value = "id")int id)
    {
        boolean deleteConsultant = consultantService.deleteConsultant(id);
        return "Supprimer";
    }

    @GetMapping("/{consultantid}")
    public ResponseEntity<ConsultantDTO> getProspectbyId(@PathVariable int consultantid) {
        try {
            Consultant consultant = consultantService.getConsultantbyId(consultantid);
            ConsultantDTO consultantDTO = convertToDTO(consultant);
            return ResponseEntity.ok(consultantDTO);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            // Log the exception for further analysis
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    private ConsultantDTO convertToDTO(Consultant consultant){
        ConsultantDTO consultantDTO = new ConsultantDTO(
                consultant.getConsultantid(),
                consultant.getConsultantname(),
                consultant.getStatus(),
                consultant.getConsultantcin(),
                consultant.getConsultantbirthdate(),
                consultant.getExperiencepro(),
                consultant.getSecteuractivite(),
                consultant.getEmail(),
                consultant.getCompetencemetier(),
                consultant.getTJM(),
                consultant.getMobile(),
                consultant.getMission()
        ) ;
        return consultantDTO ;
    }


    @GetMapping(value = "/name/{consultantId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> getConsultantName(@PathVariable int consultantId) {
        String consultantName = consultantService.getConsultantName(consultantId);
        if (consultantName != null) {
            // Create a response map with the consultantName
            Map<String, String> response = new HashMap<>();
            response.put("consultantName", consultantName);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


    /*@PutMapping("/update")
    public ResponseEntity<String> updateConsultant(@RequestBody ConsultantUpDTO consultantUpDTO) {
        String result = consultantService.updateConsultant(consultantUpDTO);
        if (result.startsWith("Consultant updated")) {

            if (consultantUpDTO.getStatus().equals("Terminé")) {
                consultantService.closeConsultant(consultantUpDTO.getConsultantid());
            }
            return ResponseEntity.ok(result);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

     */