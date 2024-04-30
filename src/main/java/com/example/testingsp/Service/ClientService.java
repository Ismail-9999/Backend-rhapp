package com.example.testingsp.Service;

import com.example.testingsp.DTO.ClientSaveDTO;

import java.util.List;

public interface ClientService {
    String  addClient(ClientSaveDTO clientSaveDTO);

    List showClient();
}
