package com.example.testingsp.Service;

import com.example.testingsp.DTO.JobsSaveDTO;
import com.example.testingsp.DTO.JobsUpDTO;
import com.example.testingsp.DTO.ProspectDTO;
import com.example.testingsp.Entite.Jobs;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobsService {
    String addjobs(JobsSaveDTO jobsSaveDTO);

    List showjobs();

    List<Jobs> getAllJobs();    //NEW
    Page<Jobs> getJobsPaginated(int page,int size);
    Jobs getJobsbyId(int id_jobs);

    String updateJobs(JobsUpDTO jobsUpDTO);
    String assignProspectToJob(int id_jobs, ProspectDTO prospectDTO);
    List<ProspectDTO> getAssignedProspects (int id_jobs);
    void unassignProspectFromJob (int id_jobs, int idtiers);

    @Transactional
    void assignProspectToJobS(int prospectId, int jobId);

    @Transactional
    void removePFromJob(int prospectId, int jobId);
}
