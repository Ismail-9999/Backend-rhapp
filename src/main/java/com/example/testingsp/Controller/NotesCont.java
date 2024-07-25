package com.example.testingsp.Controller;


import com.example.testingsp.Service.JobsService;
import com.example.testingsp.Service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://i-team.ma"})
@RequestMapping("/api/notes")
public class NotesCont {
    @Autowired
    public NotesService notesService;

}






