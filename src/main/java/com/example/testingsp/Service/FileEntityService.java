package com.example.testingsp.Service;



import com.example.testingsp.DTO.FileEntity;
import jakarta.servlet.http.HttpServletResponse;


import java.util.List;

public interface FileEntityService {

    List<FileEntity> getAllFileEntities();
    List showFiles();


    //FileEntity getFileEntityByProspectId(String prospectId);

}
