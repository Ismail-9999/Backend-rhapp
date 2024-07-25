package com.example.testingsp.Service;

import com.example.testingsp.DTO.JobsDTO;
import com.example.testingsp.DTO.JobsSaveDTO;
import com.example.testingsp.DTO.JobsUpDTO;
import com.example.testingsp.DTO.ProspectDTO;
import com.example.testingsp.Entite.Jobs;
import com.example.testingsp.Entite.Prospect;
import com.example.testingsp.ProspectAlreadyAssignedException;
import com.example.testingsp.ProspectNotAssignedException;
import com.example.testingsp.Repository.JobsRepo;
import com.example.testingsp.Repository.ProspectRepo;
import com.example.testingsp.exeption.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobsIMPL implements JobsService {
    @Autowired
    public JobsRepo jobsRepo;

    @Autowired
    public ProspectRepo prospectRepo;


    @Override
    public String addjobs(JobsSaveDTO jobsSaveDTO) {
        Jobs jobs = new Jobs(
                jobsSaveDTO.getNom_job(),
                jobsSaveDTO.getDescription_job(),
                jobsSaveDTO.getDateCreation(),
                jobsSaveDTO.getDeadline(),
                jobsSaveDTO.getPriorite(),
                jobsSaveDTO.getStatus(),
                jobsSaveDTO.getUserCreation(),
                jobsSaveDTO.getMot_cle(),
                jobsSaveDTO.getCanal(),
                jobsSaveDTO.getSecteur_opportunite(),
                jobsSaveDTO.getCommentaires(),
                jobsSaveDTO.getProspects()

        );
        jobsRepo.save(jobs);
        return jobs.getStatus();
    }
    @Override
    public List showjobs() {
        List<Jobs> showjobs = jobsRepo.findAll();
        List<JobsDTO> jobsDTOList = new ArrayList<>();
        for (Jobs j: showjobs) {
            JobsDTO jobsDTO = new JobsDTO(
                    j.getId_jobs(),
                    j.getNom_job(),
                    j.getDescription_job(),
                    j.getDateCreation(),
                    j.getDeadline(),
                    j.getPriorite(),
                    j.getStatus(),
                    j.getUserCreation(),
                    j.getMot_cle(),
                    j.getCanal(),
                    j.getSecteur_opportunite(),
                    j.getCommentaires(),
                    j.getProspects()
            );
            jobsDTOList.add(jobsDTO);
        }
        return jobsDTOList;
    }

    @Override
    public Jobs getJobsbyId(int id_jobs){
        Optional<Jobs> optionalJobs = jobsRepo.findById(id_jobs);

        if (optionalJobs.isPresent()) {
            return  optionalJobs.get();
        }
        else {
            throw  new EntityNotFoundException(("  introuvable"+ id_jobs));
        }

    }
    @Override
    public String updateJobs(JobsUpDTO jobsUpDTO) {
        if(jobsRepo.existsById(jobsUpDTO.getId_jobs())){
            Jobs jobs = jobsRepo.getById(jobsUpDTO.getId_jobs());


            jobs.setNom_job(jobsUpDTO.getNom_job());
            jobs.setDescription_job(jobsUpDTO.getDescription_job());
            jobs.setDateCreation(jobsUpDTO.getDateCreation());
            jobs.setDeadline(jobsUpDTO.getDeadline());
            jobs.setPriorite(jobsUpDTO.getPriorite());
            jobs.setStatus(jobsUpDTO.getStatus());
            jobs.setUserCreation(jobsUpDTO.getUserCreation());
            jobs.setMot_cle(jobsUpDTO.getMot_cle());
            jobs.setCanal(jobsUpDTO.getCanal());
            jobs.setSecteur_opportunite(jobsUpDTO.getSecteur_opportunite());
            jobs.setCommentaires(jobsUpDTO.getCommentaires());
            jobs.setProspects(jobsUpDTO.getProspects());

            jobsRepo.save(jobs);
            return "Jobs updated Successfully";

        }
        else {
            System.out.println("Id Introuvable");
        }
        return null;
    }
    //@Transactional
   /* public String assignProspectToJob(int id_jobs, ProspectDTO prospectDTO) {
        Jobs job = jobsRepo.findById(id_jobs).orElseThrow(() -> new EntityNotFoundException("Job not found"));

        if(prospectDTO.getNOM() == null) {
            throw new IllegalArgumentException("Prospect NOM is missing");
        }

        if(isProspectAlreadyAssignedToJob(id_jobs, prospectDTO.getNOM())){
            throw new ProspectAlreadyAssignedException("Prospect is already assigned to this job");
            //return "Prospect is already assigned to this job";
        }
        Prospect prospect = new Prospect();

        prospect.setEMAIL(prospectDTO.getEMAIL());
        prospect.setNOM(prospectDTO.getNOM());
        prospect.setStatus(prospectDTO.getStatus());
        prospect.setPAYSRESIDENCE(prospectDTO.getPAYSRESIDENCE());
        prospect.setSECTEURACTIVITE(prospectDTO.getSECTEURACTIVITE());
        prospect.setTELEPHONE(prospectDTO.getTELEPHONE());
        prospect.setCIN(prospectDTO.getCIN());
        prospect.setDateNaissance(prospectDTO.getDateNaissance());
        prospect.setPROFESSION(prospectDTO.getPROFESSION());
        prospect.setSEXE(prospectDTO.getSEXE());
        prospect.setANNEEEXPERIENCE(prospectDTO.getANNEEEXPERIENCE());
        prospect.setCOMPETENCEMETIER(prospectDTO.getCOMPETENCEMETIER());
        prospect.setCOMPETENCETECHNIQUE(prospectDTO.getCOMPETENCETECHNIQUE());
        prospect.setDISPONIBILITE(prospectDTO.getDISPONIBILITE());
        prospect.setEXPERIENCEPROFESSIONNELLE(prospectDTO.getEXPERIENCEPROFESSIONNELLE());
        prospect.setPROJETPROFESSIONNEL(prospectDTO.getPROJETPROFESSIONNEL());
        prospect.setFORMATION(prospectDTO.getFORMATION());
        prospect.setCERTIFICATION(prospectDTO.getCERTIFICATION());
        prospect.setLANGUE(prospectDTO.getLANGUE());
        prospect.setMAJCV(prospectDTO.getMAJCV());
        prospect.setMOTCLE(prospectDTO.getMOTCLE());
        prospect.setNIVEAUACADEMIQUE(prospectDTO.getNIVEAUACADEMIQUE());
        prospect.setRl_majcv(prospectDTO.getRl_majcv());
        prospect.setRl_desc(prospectDTO.getRl_desc());
        prospect.setDateCreation(prospectDTO.getDateCreation());
        prospect.setUserCreation(prospectDTO.getUserCreation());
        prospect.setJobs(job);

        prospectRepo.save(prospect);
        String result ="Prospect assigned to Job successfully";
        System.out.println("Returning result:" + result);
        return result;
    }*/

    @Transactional
    public String assignProspectToJob(int id_jobs, ProspectDTO prospectDTO) {
        Jobs job = jobsRepo.findById(id_jobs).orElseThrow(() -> new EntityNotFoundException("Job not found"));

        // Vérifiez si le prospect existe
        Prospect prospect = prospectRepo.findByNOM(prospectDTO.getNOM())
                .orElseGet(() -> {
                    Prospect newProspect = new Prospect();
                    // Set fields from DTO
                    newProspect.setEMAIL(prospectDTO.getEMAIL());
                    newProspect.setNOM(prospectDTO.getNOM());
                    // Set other fields...
                    return prospectRepo.save(newProspect);
                });

        // Vérifiez si le prospect est déjà affecté
        if (job.getProspects().contains(prospect)) {
            throw new ProspectAlreadyAssignedException("Prospect is already assigned to this job");
        }

        // Affectez le prospect au job
        job.getProspects().add(prospect);
        jobsRepo.save(job);

        return "Prospect assigned to Job successfully";
    }


    public List<ProspectDTO> getAssignedProspects(int id_jobs) {
        Jobs job = jobsRepo.findById(id_jobs)
                .orElseThrow(() -> new EntityNotFoundException("Job not found"));

        return job.getProspects().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void unassignProspectFromJob(int id_jobs, int idtiers) throws ProspectNotAssignedException,EntityNotFoundException{
        System.out.println("Unassigning Prospect with ID:" + idtiers + " from Job with ID:" + id_jobs);
        Jobs jobs = jobsRepo.findById(id_jobs)
                .orElseThrow(() -> new EntityNotFoundException("Job not found"));

        Prospect prospect = prospectRepo.findById(idtiers)
                .orElseThrow(() -> new EntityNotFoundException("Prospect not found"));

        if(!jobs.getProspects().contains(prospect)) {
            throw new ProspectNotAssignedException("Prospect is not assigned to this job");
        }
        System.out.println("Prospect " + idtiers + " is assigned to job " + id_jobs + ", proceeding to unassign.");

        jobs.getProspects().remove(prospect);
        prospect.setJobs(null);

        prospectRepo.save(prospect);
        jobsRepo.save(jobs);

        System.out.println("Prospect " + idtiers + " unassigned from job " + id_jobs + " successfully.");
    }

    private ProspectDTO convertToDTO(Prospect prospect){
        ProspectDTO prospectDTO = new ProspectDTO();
                prospectDTO.setIDTIERS(prospect.getIDTIERS());
                prospectDTO.setEMAIL(prospect.getEMAIL());
                prospectDTO.setNOM(prospect.getNOM());
                prospectDTO.setStatus(prospect.getStatus());
                prospectDTO.setPAYSRESIDENCE(prospect.getPAYSRESIDENCE());
                prospectDTO.setSECTEURACTIVITE(prospect.getSECTEURACTIVITE());
                prospectDTO.setTELEPHONE(prospect.getTELEPHONE());
                prospectDTO.setCIN(prospect.getCIN());
                prospectDTO.setDateNaissance(prospect.getDateNaissance());
                prospectDTO.setPROFESSION(prospect.getPROFESSION());
                prospectDTO.setSEXE(prospect.getSEXE());
                prospectDTO.setANNEEEXPERIENCE(prospect.getANNEEEXPERIENCE());
                prospectDTO.setCOMPETENCEMETIER(prospect.getCOMPETENCEMETIER());
                prospectDTO.setCOMPETENCETECHNIQUE(prospect.getCOMPETENCETECHNIQUE());
                prospectDTO.setDISPONIBILITE(prospect.getDISPONIBILITE());
                prospectDTO.setEXPERIENCEPROFESSIONNELLE(prospect.getEXPERIENCEPROFESSIONNELLE());
                prospectDTO.setPROJETPROFESSIONNEL(prospect.getPROJETPROFESSIONNEL());
                prospectDTO.setFORMATION(prospect.getFORMATION());
                prospectDTO.setCERTIFICATION(prospect.getCERTIFICATION());
                prospectDTO.setLANGUE(prospect.getLANGUE());
                prospectDTO.setMAJCV(prospect.getMAJCV());
                prospectDTO.setMOTCLE(prospect.getMOTCLE());
                prospectDTO.setNIVEAUACADEMIQUE(prospect.getNIVEAUACADEMIQUE());
                prospectDTO.setRl_majcv(prospect.getRl_majcv());
                prospectDTO.setRl_desc(prospect.getRl_desc());
                prospectDTO.setDateCreation(prospect.getDateCreation());
                prospectDTO.setUserCreation(prospect.getUserCreation());
        // prospectDTO.setJobs(prospect.getJobs());

        return prospectDTO ;
    }



    public boolean isProspectAlreadyAssignedToJob(int id_jobs, String NOM) {
        Jobs job = jobsRepo.findById(id_jobs).orElseThrow(() -> new EntityNotFoundException("Job not found"));
        return job.getProspects().stream().anyMatch(prospect -> NOM.equals(prospect.getNOM()));
    }
                //New

    public List<Jobs> getAllJobs(){
        return jobsRepo.findAll();
    }
    public Page<Jobs> getJobsPaginated(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return jobsRepo.findAll(pageable);
    }



    /* @Override
    public List<Jobs> getAllJobs(){
        List<Jobs> jobs = jobsRepo.findAll();
        return jobs.stream().map(this::convertToDTO).collect(Collectors.toList());
    }*/

    @Override
    @Transactional
    public void assignProspectToJobS(int prospectId, int jobId) {
        Prospect prospect = prospectRepo.findById(prospectId)
                .orElseThrow(() -> new ResourceNotFoundException("Prospect not found"));
        Jobs job = jobsRepo.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found"));

        prospect.getJobs().add(job);
        job.getProspects().add(prospect);

        prospectRepo.save(prospect);
        jobsRepo.save(job);
    }

    @Override
    @Transactional
    public void removePFromJob(int prospectId, int jobId) {
        Prospect prospect = prospectRepo.findById(prospectId)
                .orElseThrow(() -> new ResourceNotFoundException("Prospect not found"));
        Jobs job = jobsRepo.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found"));

        prospect.getJobs().remove(job);
        job.getProspects().remove(prospect);

        prospectRepo.save(prospect);
        jobsRepo.save(job);
    }
}
