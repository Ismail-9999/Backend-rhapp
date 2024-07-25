package com.example.testingsp.Service;

import com.example.testingsp.DTO.*;
import com.example.testingsp.Entite.Consultant;
import com.example.testingsp.Entite.Prospect;
import com.example.testingsp.Repository.ConsultantRepo;
import com.example.testingsp.Repository.ProspectRepo;
import com.example.testingsp.Repository.TaskRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class TaskIMPL implements  TaskService {

    @Autowired
    public TaskRepo taskRepo ;

}

