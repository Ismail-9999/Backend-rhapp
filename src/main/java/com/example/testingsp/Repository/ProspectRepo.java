package com.example.testingsp.Repository;

import com.example.testingsp.DTO.MajProsDTO;
import com.example.testingsp.DTO.ProsDto;
import com.example.testingsp.DTO.ProspectDTO;
import com.example.testingsp.Entite.Prospect;
import com.example.testingsp.Entite.TestingSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProspectRepo extends JpaRepository<Prospect,Integer> {
    @Query("SELECT new com.example.testingsp.DTO.ProsDto(p.SECTEURACTIVITE," +
            " COUNT(p)) FROM Prospect p where p.SECTEURACTIVITE !='Non renseigné'" +
            "GROUP BY p.SECTEURACTIVITE")
    List<ProsDto> getChartData();

    @Query("SELECT new com.example.testingsp.DTO.MajProsDTO(SUBSTRING(CAST(p.rl_majcv AS string)" +
            ", 1, 4)," +
            " COUNT(p)) FROM Prospect p WHERE p.rl_majcv IS NOT NULL " +
            "GROUP BY p.rl_majcv")

    List<MajProsDTO>  getMajData();

    @Query("SELECT p FROM Prospect p" +
            " WHERE p.DISPONIBILITE = 'A relancé'")
    List<Prospect> findProspectsWithDisponibiliteNotRelance();

    @Query("SELECT p FROM Prospect p WHERE p.NOM LIKE %:keyword% OR p.COMPETENCETECHNIQUE LIKE %:keyword%")
    List<Prospect> findByKeyword(@Param("keyword") String keyword);
    //List<Prospect> findByMOTCLEContainingIgnoreCase(@Param("keyword") String keyword);

    Optional<Prospect> findByIDTIERS(int id);
    Optional<Prospect> findByNOM(String nom);


}

