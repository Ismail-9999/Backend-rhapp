package com.example.testingsp.Controller;

import com.example.testingsp.DTO.CommentaireDTO;
import com.example.testingsp.DTO.CommentaireSaveDTO;
import com.example.testingsp.DTO.CommentaireUpDTO;
import com.example.testingsp.DTO.JobsDTO;
import com.example.testingsp.Entite.Commentaire;
import com.example.testingsp.Entite.Jobs;
import com.example.testingsp.Repository.CommentaireRepo;
import com.example.testingsp.Service.CommentaireService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://i-team.ma"})
@RequestMapping("/api/commentaire")
public class CommentaireCont {

    @Autowired
    public CommentaireService commentaireService;

    @GetMapping(path = "/show")
    public List<CommentaireDTO> showCommentaire() {
        List<CommentaireDTO> allcommentaire = commentaireService.showcommentaire();
        return allcommentaire;
    }

    @PostMapping(path = "/add")
    public String savecommentaire(@RequestBody CommentaireSaveDTO commentaireSaveDTO){
        String id = commentaireService.addcommentaire(commentaireSaveDTO);
        return id;
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updatecommentaire(@RequestBody CommentaireUpDTO commentaireUpDTO){
        String result = commentaireService.updateCommentaire(commentaireUpDTO);
        if (result.startsWith("Commentaire updated")){
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping(path = "/{id_commentaire}")
    public ResponseEntity<CommentaireDTO> getCommentairebyId(@PathVariable int id_commentaire){
        try {
            Commentaire commentaire  = commentaireService.getCommentairebyId(id_commentaire);
            CommentaireDTO commentaireDTO = convertToDTO(commentaire);
            return ResponseEntity.ok(commentaireDTO);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    private CommentaireDTO convertToDTO(Commentaire commentaire) {
        CommentaireDTO commentaireDTO = new CommentaireDTO(
                commentaire.getId_commentaire(),
                commentaire.getCommentaire(),
                commentaire.getUserCreation(),
                commentaire.getDateCreation(),
                commentaire.getJobs()
        );
        return commentaireDTO;
    }

}
