package com.example.testingsp.Controller;


import com.example.testingsp.DTO.ApoffresDTO;
import com.example.testingsp.DTO.AppoffresSaveDTO;
import com.example.testingsp.Service.ApoffresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://i-team.ma"})
@RequestMapping(path = "/api/offres")
public class AppoffresCont {

    @Autowired
    public ApoffresService apoffresService ;


    @GetMapping(path="/show")
    @Cacheable("appoffres")
    public List<ApoffresDTO> showOff (){
        List<ApoffresDTO> alloffres  = apoffresService.showOffres();
        return alloffres ;
    }

    @PostMapping(path="/add")
    @CacheEvict(value = "appoffres", allEntries = true)
    public String saveOffres(@RequestBody AppoffresSaveDTO appoffresSaveDTO){
        String id = apoffresService.addOffres(appoffresSaveDTO);
        return id ;
    }
}
