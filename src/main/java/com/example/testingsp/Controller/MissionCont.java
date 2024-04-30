package com.example.testingsp.Controller;


import com.example.testingsp.DTO.*;
import com.example.testingsp.Service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/mission")
public class MissionCont {

    @Autowired
    public MissionService missionService ;

    @PostMapping("add")
    public  String savemission (@RequestBody MissionsaveDTO missionsaveDTO){
        String id = missionService.addMission(missionsaveDTO);
        return id ;
    }

    @GetMapping("mission")
    public List<MissionDTO> showMission (){
        List<MissionDTO> allMission = missionService.showMission();
        return allMission ;
    }


    @PostMapping("/add/cons-mis")
    public ResponseEntity<Map<String, String>> addConsultantToSalarie(@RequestBody Map<String, Integer> requestBody) {
        int missionid = requestBody.get("missionid");
        int consultantid = requestBody.get("consultantid");

        missionService.addConsultantToMission(missionid, consultantid);

        // Create a response map with a success message
        Map<String, String> response = new HashMap<>();
        response.put("message", "Relationship established successfully.");
        return ResponseEntity.<Map<String, String>>ok(response);
    }

    @GetMapping(value = "/name/{missionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> getMissionName(@PathVariable int missionId) {
        String designation = missionService.getMissionDes(missionId);
        if (designation != null) {
            // Create a response map with the consultantName
            Map<String, String> response = new HashMap<>();
            response.put("Designation", designation);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/msdata")
    public ResponseEntity<List<Object[]>> getChartData() {
        List<Object[]> chartData =  missionService.getServicesdata();
        return ResponseEntity.ok(chartData);
    }

    @GetMapping("/clidata")
    public ResponseEntity<List<Object[]>> getChart2Data() {
        List<Object[]> chartData =  missionService.getClientdata();
        return ResponseEntity.ok(chartData);
    }




    @GetMapping("/dstab")
    public List<ServiceChart> getDashtable() {
        return missionService.getDashTable();
    }


}
