package be.projet.Loree.models.dto;


import be.projet.Loree.models.CommandeStatus;
import be.projet.Loree.models.entity.Commande;
import be.projet.Loree.models.entity.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CommandeDTO {

    private Long id;
    private LocalDate start;
    private Utilisateur utilisateur;
    private CommandeStatus status;

    public static CommandeDTO from(Commande entity){
        if(entity == null)
            return null;

        return CommandeDTO.builder()
                .id(entity.getId())
                .start(entity.getStart())
                .status(entity.getStatus())
                .utilisateur(entity.getUtilisateur())
                .build();

    }

}
