package com.example.testingsp.Service;


import com.example.testingsp.DTO.FileEntity;
import com.example.testingsp.DTO.FileEntityDTO;

import com.example.testingsp.Repository.FileEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
