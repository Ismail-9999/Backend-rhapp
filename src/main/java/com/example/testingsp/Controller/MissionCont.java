package com.example.testingsp.Controller;


import com.example.testingsp.DTO.*;
import com.example.testingsp.Service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://i-team.ma"})
@RequestMapping(path = "/api/mission")
public class MissionCont {

    @Autowired
    public MissionService missionService ;

    @PostMapping("add")
    @CacheEvict(value = "mission", allEntries = true)
    public  String savemission (@RequestBody MissionsaveDTO missionsaveDTO){
        String id = missionService.addMission(missionsaveDTO);
        return id ;
    }

    @GetMapping("mission")
    @Cacheable("mission")
    public List<MissionDTO> showMission (){
        List<MissionDTO> allMission = missionService.showMission();
        return allMission ;
    }


    @PostMapping("/add/cons-mis")
    @CacheEvict(value = "mission", allEntries = true)
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
    @CacheEvict(value = "mission", allEntries = true)
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
    @CacheEvict(value = "mission", allEntries = true)
    public ResponseEntity<List<Object[]>> getChartData() {
        List<Object[]> chartData =  missionService.getServicesdata();
        return ResponseEntity.ok(chartData);
    }

    @GetMapping("/clidata")
    @CacheEvict(value = "mission", allEntries = true)
    public ResponseEntity<List<Object[]>> getChart2Data() {
        List<Object[]> chartData =  missionService.getClientdata();
        return ResponseEntity.ok(chartData);
    }




    @GetMapping("/dstab")
    @CacheEvict(value = "mission", allEntries = true)
    public List<ServiceChart> getDashtable() {
        return missionService.getDashTable();
    }


}
