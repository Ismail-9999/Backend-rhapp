package com.example.testingsp.Repository;


import com.example.testingsp.DTO.ServiceChart;
import com.example.testingsp.Entite.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MissionRepo extends JpaRepository<Mission,Integer> {

    @Query(value = "SELECT c.consultantname AS nom, SUM(a.nombrej) AS jour_nbr " +
            "FROM mission_missions b " +
            "JOIN mission a ON a.mission_id = b.mission_mission_id " +
            "JOIN consultants c ON b.missions_consultant_id = c.consultant_id " +
            "GROUP BY c.consultantname " +
            "ORDER BY SUM(a.nombrej) DESC", nativeQuery = true)
    List<Object[]> getServicesdata();


    @Query(value ="select d.clientname as nom, count(a.mission_ref) as counter from mission a\n"+
            "join client d\n" +
            "on   a.client_clientid = d.clientid\n" +
            "group by  d.clientname ",nativeQuery = true)
    List<Object[]> getClientdata();



    @Query(value = "select  c.consultantname, c.tjm, d.clientname, count(a.mission_ref) as countmis from mission a " +
            "join mission_missions b " +
            "on a.mission_id = b.mission_mission_id " +
            "join consultants c " +
            "on b.missions_consultant_id = c.consultant_id " +
            "join client d " +
            "on a.client_clientid = d.clientid " +
            "group by c.consultantname, c.tjm, d.clientname " +
            "order by count(a.mission_ref) desc", nativeQuery = true)

    List<Object[]> getDashTable();
}
