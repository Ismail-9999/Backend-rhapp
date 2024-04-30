package com.example.testingsp.Service;

import com.example.testingsp.DTO.AppoffresSaveDTO;

import java.util.List;

public interface ApoffresService {
    String addOffres(AppoffresSaveDTO appoffresSaveDTO);

    List showOffres();
}
