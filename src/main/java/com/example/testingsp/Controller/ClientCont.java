package com.example.testingsp.Controller;


import com.example.testingsp.DTO.ClientDTO;
import com.example.testingsp.DTO.ClientSaveDTO;
import com.example.testingsp.Entite.Client;
import com.example.testingsp.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(path = "/api/client")

public class ClientCont {

    @Autowired
    public ClientService clientService ;

    @GetMapping(path = "/show")
    public List<ClientDTO> showCL (){
        List<ClientDTO> allClient =clientService.showClient();
        return allClient;
    }

    @PostMapping(path = "/add")
    public String saveclient(@RequestBody ClientSaveDTO clientSaveDTO){
        String id = clientService.addClient(clientSaveDTO);
        return id ;
    }
}
