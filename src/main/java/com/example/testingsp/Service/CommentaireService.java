package com.example.testingsp.Service;

import com.example.testingsp.DTO.CommentaireSaveDTO;
import com.example.testingsp.DTO.CommentaireUpDTO;
import com.example.testingsp.DTO.JobsSaveDTO;
import com.example.testingsp.Entite.Commentaire;

import java.util.List;

public interface CommentaireService {
    String addcommentaire(CommentaireSaveDTO commentaireSaveDTO);

    List showcommentaire();
    String updateCommentaire(CommentaireUpDTO commentaireUpDTO);

    Commentaire getCommentairebyId(int id_commentaire);
}
