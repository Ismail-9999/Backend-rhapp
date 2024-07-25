package com.example.testingsp.Controller;

import com.example.testingsp.DTO.*;
import com.example.testingsp.Entite.Jobs;
import com.example.testingsp.Entite.Prospect;
import com.example.testingsp.ProspectAlreadyAssignedException;
import com.example.testingsp.ProspectNotAssignedException;
import com.example.testingsp.Service.JobsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://i-team.ma"})
@RequestMapping("/api/jobs")
public class JobsCont {
    @Autowired
    public JobsService jobsService;



    @GetMapping(path = "/show")
    public List<JobsDTO> showjobs() {
        List<JobsDTO> alljobs = jobsService.showjobs();
        return alljobs;
    }
    @PostMapping(path = "/add")
    public String saveJobs(@RequestBody JobsSaveDTO jobsSaveDTO) {
        String id = jobsService.addjobs(jobsSaveDTO);
        return id;
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateJobs(@RequestBody JobsUpDTO jobsUpDTO) {
        String result = jobsService.updateJobs(jobsUpDTO);
        if (result.startsWith("Jobs updated")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id_jobs}")
    public ResponseEntity<JobsDTO> getJobsbyId(@PathVariable int id_jobs) {
        try {
            Jobs jobs  = jobsService.getJobsbyId(id_jobs);
            JobsDTO jobsDTO  = convertToDTO(jobs);
            return ResponseEntity.ok(jobsDTO);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

                //NEW
     /*@GetMapping("/all")
    public ResponseEntity<List<Jobs>> getAllJobs(){
        List<Jobs> jobs = jobsService.getAllJobs();
        return new ResponseEntity<>(jobs,HttpStatus.OK);
    }*/
    @GetMapping("/all")
    public ResponseEntity<Page<Jobs>> getAllJobs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Jobs> jobs = jobsService.getJobsPaginated(page, size);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }





    private JobsDTO convertToDTO(Jobs jobs){
        JobsDTO jobsDTO = new JobsDTO(
                jobs.getId_jobs(),
                jobs.getNom_job(),
                jobs.getDescription_job(),
                jobs.getDateCreation(),
                jobs.getDeadline(),
                jobs.getPriorite(),
                jobs.getStatus(),
                jobs.getUserCreation(),
                jobs.getMot_cle(),
                jobs.getCanal(),
                jobs.getSecteur_opportunite(),
                jobs.getCommentaires(),
                jobs.getProspects()

        );
        return jobsDTO;
    }

    @PostMapping(path = "/{id_jobs}/assignProspect")
    public ResponseEntity<String> assignProspectToJob(@PathVariable int id_jobs, @RequestBody ProspectDTO prospectDTO) {
        /*try {
            System.out.println("Received request to assign prospect to job with ID:"+id_jobs);
            System.out.println("Prospect details:" + prospectDTO);

            String result = jobsService.assignProspectToJob(id_jobs,prospectDTO);
            if("Prospect id already assigned to this job".equals(result)){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
            }

            System.out.println("Prospect assigned successfully:" +result);

            return ResponseEntity.ok(result);
        } catch (EntityNotFoundException ex) {
            System.out.println("Job not found with ID:" + id_jobs);
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }*/

        try {
            String result = jobsService.assignProspectToJob(id_jobs, prospectDTO);
            return ResponseEntity.ok(result);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (ProspectAlreadyAssignedException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
        }
    }


    @GetMapping(path="/{id_jobs}/assignedProspects")
    public ResponseEntity<List<ProspectDTO>> getAssignedProspects(@PathVariable int id_jobs) {
      try {
          List<ProspectDTO> assignedProspects = jobsService.getAssignedProspects(id_jobs);
          return ResponseEntity.ok(assignedProspects);
      }catch (EntityNotFoundException ex) {
          return ResponseEntity.notFound().build();
      }catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
      }
    }
    @DeleteMapping(path="/{id_jobs}/prospect/{idtiers}")
    public ResponseEntity<String> unassignProspectFromJob(@PathVariable int id_jobs,@PathVariable int idtiers){
        try {
            jobsService.unassignProspectFromJob(id_jobs, idtiers);
            return ResponseEntity.ok("Prospect unassigned successfully");
        } catch (ProspectNotAssignedException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Prospect is not assigned to this job");
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job or Prospect not found");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error unassigning prospect");
        }
    }



    @PostMapping("/assign")
    public ResponseEntity<Void> assignProspectToJob(@RequestParam int prospectId, @RequestParam int jobId) {
        jobsService.assignProspectToJobS(prospectId, jobId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeProspectFromJob(@RequestParam int prospectId, @RequestParam int jobId) {
        jobsService.removePFromJob(prospectId, jobId);
        return ResponseEntity.ok().build();
    }

}








