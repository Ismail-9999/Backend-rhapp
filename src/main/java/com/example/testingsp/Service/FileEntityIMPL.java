package com.example.testingsp.Service;


import com.example.testingsp.DTO.FileEntity;
import com.example.testingsp.DTO.FileEntityDTO;

import com.example.testingsp.Repository.FileEntityRepo;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileEntityIMPL implements FileEntityService {
    @Autowired
    public FileEntityRepo fileEntityRepo;


    @Override
    public List<FileEntity> getAllFileEntities() {
        return fileEntityRepo.findAll();
    }
    @Override
    public List showFiles(){
        List<FileEntity> showfiles = fileEntityRepo.findAll();
        List<FileEntityDTO> fileEntityDTOList = new ArrayList<>();
        for (FileEntity i : showfiles) {
            FileEntityDTO fileEntityDTO = new FileEntityDTO(
                    i.getId(),
                    i.getFileName(),
                    i.getProspectId());
            fileEntityDTOList.add(fileEntityDTO);
        }
        return fileEntityDTOList;
    }



    /*@Override
    public FileEntity getFileEntityByProspectId(String prospectId) {
        return fileEntityRepo.findByProspectId(prospectId);
    }

     */

}
