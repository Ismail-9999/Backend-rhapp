package com.example.testingsp.Controller;


import com.example.testingsp.DTO.ApoffresDTO;
import com.example.testingsp.DTO.AppoffresSaveDTO;
import com.example.testingsp.Service.ApoffresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/offres")
public class AppoffresCont {

    @Autowired
    public ApoffresService apoffresService ;


    @GetMapping(path="/show")
    public List<ApoffresDTO> showOff (){
        List<ApoffresDTO> alloffres  = apoffresService.showOffres();
        return alloffres ;
    }

    @PostMapping(path="/add")
    public String saveOffres(@RequestBody AppoffresSaveDTO appoffresSaveDTO){
        String id = apoffresService.addOffres(appoffresSaveDTO);
        return id ;
    }
}
