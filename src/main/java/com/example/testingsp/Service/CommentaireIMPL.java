package com.example.testingsp.Service;

import com.example.testingsp.DTO.CommentaireDTO;
import com.example.testingsp.DTO.CommentaireSaveDTO;
import com.example.testingsp.DTO.CommentaireUpDTO;
import com.example.testingsp.Entite.Commentaire;
import com.example.testingsp.Entite.Jobs;
import com.example.testingsp.Repository.CommentaireRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireIMPL implements CommentaireService{
    @Autowired
    public CommentaireRepo commentaireRepo;

    @Override
    public String addcommentaire(CommentaireSaveDTO commentaireSaveDTO) {
        Commentaire commentaire = new Commentaire(
                commentaireSaveDTO.getCommentaire(),
                commentaireSaveDTO.getUserCreation(),
                commentaireSaveDTO.getDateCreation(),
                commentaireSaveDTO.getJobs()

        );
        commentaireRepo.save(commentaire);
        return commentaire.getUserCreation();

    }

    @Override
    public List showcommentaire() {
        List<Commentaire> showcommentaire = commentaireRepo.findAll();
        List<CommentaireDTO> commentaireDTOList = new ArrayList<>();
        for (Commentaire c: showcommentaire){
            CommentaireDTO commentaireDTO = new CommentaireDTO(
                    c.getId_commentaire(),
                    c.getCommentaire(),
                    c.getUserCreation(),
                    c.getDateCreation(),
                    c.getJobs()

            );
            commentaireDTOList.add(commentaireDTO);
        }
        return commentaireDTOList;
    }

    @Override
    public Commentaire getCommentairebyId(int id_commentaire){
        Optional<Commentaire> optionalCommentaire = commentaireRepo.findById(id_commentaire);

        if (optionalCommentaire.isPresent()) {
            return  optionalCommentaire.get();
        }
        else {
            throw  new EntityNotFoundException(("  introuvable"+ id_commentaire));
        }

    }

    @Override
    public String updateCommentaire(CommentaireUpDTO commentaireUpDTO) {
        if (commentaireRepo.existsById(commentaireUpDTO.getId_commentaire())) {
            Commentaire commentaire = commentaireRepo.getById(commentaireUpDTO.getId_commentaire());

            commentaire.setId_commentaire(commentaireUpDTO.getId_commentaire());
            commentaire.setCommentaire(commentaireUpDTO.getCommentaire());
            commentaire.setJobs(commentaireUpDTO.getJobs());
            commentaire.setDateCreation(commentaireUpDTO.getDateCreation());
            commentaire.setUserCreation(commentaireUpDTO.getUserCreation());
            commentaireRepo.save(commentaire);
            return "Commentaire updated Successfully";
        }
        else {
            System.out.println("Id Introuvable");
        }
        return null;
    }
}
