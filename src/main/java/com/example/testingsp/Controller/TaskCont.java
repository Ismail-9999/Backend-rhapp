package com.example.testingsp.Controller;


import com.example.testingsp.Service.JobsService;

import com.example.testingsp.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = {"http://i-team.ma"})
@RequestMapping("/api/task")
public class TaskCont {
    @Autowired
    public TaskService taskService;

}






