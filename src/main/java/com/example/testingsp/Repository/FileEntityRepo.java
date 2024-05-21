package com.example.testingsp.Repository;

import com.example.testingsp.DTO.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileEntityRepo extends JpaRepository<FileEntity,Long> {


    //FileEntity findByProspectId(String prospectId);
}
