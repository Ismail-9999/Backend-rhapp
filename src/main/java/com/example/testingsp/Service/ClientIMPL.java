package com.example.testingsp.Service;


import com.example.testingsp.DTO.ClientDTO;
import com.example.testingsp.DTO.ClientSaveDTO;
import com.example.testingsp.Entite.Client;
import com.example.testingsp.Repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientIMPL implements  ClientService{

    @Autowired
    public ClientRepo clientRepo ;

    @Override
    public String  addClient(ClientSaveDTO clientSaveDTO){
        Client client = new Client(
                clientSaveDTO.getClientname(),
                clientSaveDTO.getClient_add(),
                clientSaveDTO.getClient_ice(),
                clientSaveDTO.getMission(),
                clientSaveDTO.getApofres()
        );
        clientRepo.save(client);
        return client.getClientname();
    }


    @Override
    public List showClient(){
        List<Client> showclient = clientRepo.findAll();
        List<ClientDTO> clientDTOList = new ArrayList<>();

        for (Client i : showclient){
        ClientDTO clientDTO  = new ClientDTO(
          i.getClientid(),
          i.getClientname(),
          i.getClient_add(),
          i.getClient_ice(),
          i.getMission(),
                i.getApofres()
        );
        clientDTOList.add(clientDTO);
        }
            return clientDTOList ;
    }

}

