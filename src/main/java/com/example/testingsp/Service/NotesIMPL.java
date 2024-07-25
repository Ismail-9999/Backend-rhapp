package com.example.testingsp.Service;


import com.example.testingsp.Repository.NotesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class NotesIMPL implements NotesService{
    @Autowired
    public NotesRepo notesRepo;


}
