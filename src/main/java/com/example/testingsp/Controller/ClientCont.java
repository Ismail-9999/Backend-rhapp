package com.example.testingsp.Controller;


import com.example.testingsp.DTO.ClientDTO;
import com.example.testingsp.DTO.ClientSaveDTO;
import com.example.testingsp.Entite.Client;
import com.example.testingsp.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = {"http://i-team.ma"})
@RequestMapping(path = "/api/client")

public class ClientCont {

    @Autowired
    public ClientService clientService ;

    @GetMapping(path = "/show")
    @Cacheable("client")
    public List<ClientDTO> showCL (){
        List<ClientDTO> allClient =clientService.showClient();
        return allClient;
    }

    @PostMapping(path = "/add")
    @CacheEvict(value = "client", allEntries = true)
    public String saveclient(@RequestBody ClientSaveDTO clientSaveDTO){
        String id = clientService.addClient(clientSaveDTO);
        return id ;
    }
}

